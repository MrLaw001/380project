package hkmu.comps380f.dao;

import hkmu.comps380f.exception.AttachmentNotFound;
import hkmu.comps380f.exception.TicketNotFound;
import hkmu.comps380f.model.AppUser;
import hkmu.comps380f.model.Attachment;
import hkmu.comps380f.model.Ticket;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Resource
    private TicketRepository ticketRepo;
    @Resource
    private AttachmentRepository attachmentRepo;

    @Transactional
    public List<Ticket> getTickets() { return ticketRepo.findAll(); }

    @Transactional
    public Ticket getTicket(long id) throws TicketNotFound {
        Ticket ticket = ticketRepo.findById(id).orElse(null);
        if (ticket == null) {
            throw new TicketNotFound(id);
        }
        return ticket;
    }

    @Transactional
    public Attachment getAttachment(long ticketId, UUID attachmentId)
        throws TicketNotFound, AttachmentNotFound {
        Ticket ticket = this.getTicket(ticketId);
        Attachment attachment = attachmentRepo.findById(attachmentId).orElse(null);
        if (attachment == null || !attachment.getTicket().equals(ticket)) {
            throw new AttachmentNotFound(attachmentId);
        }
        return attachment;
    }
    @Resource
    private AppUserRepository appUserRepo;
    @Transactional
    public long createTicket(String customerName, String subject,
                             String body, List<MultipartFile> attachments)
            throws IOException {
        AppUser customer = appUserRepo.findById(customerName).orElse(null);
        if (customer == null){
            throw new RuntimeException("User " + customerName + " not found.");
        }
        Ticket ticket = new Ticket();
        ticket.setCustomer(customer);
        ticket.setSubject(subject);
        ticket.setBody(body);
        for (MultipartFile filePart : attachments) {
            Attachment attachment = new Attachment();
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            attachment.setTicket(ticket);
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null
                    && attachment.getContents().length > 0) {
                ticket.getAttachments().add(attachment);
            }
        }
        Ticket savedTicket = ticketRepo.save(ticket);
        customer.getTickets().add(savedTicket);
        return savedTicket.getId();
    }

    @Transactional
    public void delete(long id) throws TicketNotFound {
        Ticket deletedTicket = ticketRepo.findById(id).orElse(null);
        if (deletedTicket == null) {
            throw new TicketNotFound(id);
        }
        deletedTicket.getCustomer().getTickets().remove(deletedTicket);
        ticketRepo.delete(deletedTicket);
    }

    @Transactional(rollbackFor =  {TicketNotFound.class, AttachmentNotFound.class})
    public void deleteAttachment(long ticketId, UUID attachmentId)
        throws TicketNotFound, AttachmentNotFound {
        Ticket ticket = this.getTicket(ticketId);
        Attachment attachment = attachmentRepo.findById(attachmentId).orElse(null);
        if (attachment == null || !attachment.getTicket().equals(ticket)) {
            throw new AttachmentNotFound(attachmentId);
        }
        ticket.deleteAttachment(attachment);
        ticketRepo.save(ticket);
    }

    @Transactional
    public void updateTicket(long id, String subject,
                             String body, List<MultipartFile> attachments)
            throws IOException, TicketNotFound {
        Ticket updatedTicket = ticketRepo.findById(id).orElse(null);
        if (updatedTicket == null) {
            throw new TicketNotFound(id);
        }
        updatedTicket.setSubject(subject);
        updatedTicket.setBody(body);
        for (MultipartFile filePart : attachments) {
            Attachment attachment = new Attachment();
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            attachment.setTicket(updatedTicket);
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null
                    && attachment.getContents().length > 0) {
                updatedTicket.getAttachments().add(attachment);
            }
        }
        ticketRepo.save(updatedTicket);
    }
}
