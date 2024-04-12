//package hkmu.comps380f.dao;
//
//import hkmu.comps380f.exception.AttachmentNotFound;
//import hkmu.comps380f.exception.TicketNotFound;
//import hkmu.comps380f.exception.UserNotFound;
//import hkmu.comps380f.model.Attachment;
//import hkmu.comps380f.model.Ticket;
//import hkmu.comps380f.model.User;
//import jakarta.annotation.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class UserService {
//    @Resource
//    private UserRepository userRepo;
//    @Resource
//    private AttachmentRepository attachmentRepo;
//
//    @Transactional
//    public List<User> geUsers() { return userRepo.findAll(); }
//
//    @Transactional
//    public User getUser(long id) throws UserNotFound {
//        User user = userRepo.findById(id).orElse(null);
//        if (user == null) {
//            throw new UserNotFound(id);
//        }
//        return user;
//    }
//
////    @Transactional
////    public Attachment getAttachment(long ticketId, UUID attachmentId)
////        throws TicketNotFound, AttachmentNotFound {
////        Ticket ticket = this.getTicket(ticketId);
////        Attachment attachment = attachmentRepo.findById(attachmentId).orElse(null);
////        if (attachment == null || !attachment.getTicket().equals(ticket)) {
////            throw new AttachmentNotFound(attachmentId);
////        }
////        return attachment;
////    }
//    @Resource
//    private UserRepository UserRepo;
//    @Transactional
//    public long createUser(String customerName, String subject,
//                             String body, List<MultipartFile> attachments)
//            throws IOException {
//        User user = UserRepo.findById(userName).orElse(null);
//        if (user == null){
//            throw new RuntimeException("User " + user + " not found.");
//        }
//        user = new User();
//        user.setUserName(user.getUserName());
//        user.setPassword(user.getPassword());
//        user.set(body);
//        for (MultipartFile filePart : attachments) {
//            Attachment attachment = new Attachment();
//            attachment.setName(filePart.getOriginalFilename());
//            attachment.setMimeContentType(filePart.getContentType());
//            attachment.setContents(filePart.getBytes());
//            attachment.setTicket(ticket);
//            if (attachment.getName() != null && attachment.getName().length() > 0
//                    && attachment.getContents() != null
//                    && attachment.getContents().length > 0) {
//                ticket.getAttachments().add(attachment);
//            }
//        }
//        Ticket savedTicket = ticketRepo.save(ticket);
//        customer.getTickets().add(savedTicket);
//        return savedTicket.getId();
//    }
//
//    @Transactional
//    public void delete(long id) throws TicketNotFound {
//        Ticket deletedTicket = ticketRepo.findById(id).orElse(null);
//        if (deletedTicket == null) {
//            throw new TicketNotFound(id);
//        }
//        deletedTicket.getCustomer().getTickets().remove(deletedTicket);
//        ticketRepo.delete(deletedTicket);
//    }
//
//    @Transactional(rollbackFor =  {TicketNotFound.class, AttachmentNotFound.class})
//    public void deleteAttachment(long ticketId, UUID attachmentId)
//        throws TicketNotFound, AttachmentNotFound {
//        Ticket ticket = this.getTicket(ticketId);
//        Attachment attachment = attachmentRepo.findById(attachmentId).orElse(null);
//        if (attachment == null || !attachment.getTicket().equals(ticket)) {
//            throw new AttachmentNotFound(attachmentId);
//        }
//        ticket.deleteAttachment(attachment);
//        ticketRepo.save(ticket);
//    }
//
//    @Transactional
//    public void updateTicket(long id, String subject,
//                             String body, List<MultipartFile> attachments)
//            throws IOException, TicketNotFound {
//        Ticket updatedTicket = ticketRepo.findById(id).orElse(null);
//        if (updatedTicket == null) {
//            throw new TicketNotFound(id);
//        }
//        updatedTicket.setSubject(subject);
//        updatedTicket.setBody(body);
//        for (MultipartFile filePart : attachments) {
//            Attachment attachment = new Attachment();
//            attachment.setName(filePart.getOriginalFilename());
//            attachment.setMimeContentType(filePart.getContentType());
//            attachment.setContents(filePart.getBytes());
//            attachment.setTicket(updatedTicket);
//            if (attachment.getName() != null && attachment.getName().length() > 0
//                    && attachment.getContents() != null
//                    && attachment.getContents().length > 0) {
//                updatedTicket.getAttachments().add(attachment);
//            }
//        }
//        ticketRepo.save(updatedTicket);
//    }
//}
