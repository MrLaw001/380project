//package hkmu.comps380f.controller;
//
//import hkmu.comps380f.dao.TicketService;
//import hkmu.comps380f.exception.AttachmentNotFound;
//import hkmu.comps380f.exception.TicketNotFound;
//import hkmu.comps380f.model.AppUser;
//import hkmu.comps380f.model.Attachment;
//import hkmu.comps380f.model.Ticket;
//import hkmu.comps380f.model.User;
//import hkmu.comps380f.view.DownloadingView;
//import jakarta.annotation.Resource;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.view.RedirectView;
//
//import java.io.IOException;
//import java.security.Principal;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    @Resource
//    private TicketService ticketService;
//
//    @GetMapping(value = {"", "/list"})
//    public String list(ModelMap model) {
//        model.addAttribute("ticketDatabase", ticketService.getTickets());
//        return "ticket/list";
//    }
//    public static class UserForm {
//        private AppUser username;
//        private String password;
//        private String confirmpassword;
//        private String fullname;
//        private String email;
//        private String delivery;
//
//        public AppUser getUsername() {
//            return username;
//        }
//
//        public void setUsername(AppUser username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getConfirmpassword() {
//            return confirmpassword;
//        }
//
//        public void setConfirmpassword(String confirmpassword) {
//            this.confirmpassword = confirmpassword;
//        }
//
//        public String getFullname() {
//            return fullname;
//        }
//
//        public void setFullname(String fullname) {
//            this.fullname = fullname;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getDelivery() {
//            return delivery;
//        }
//
//        public void setDelivery(String delivery) {
//            this.delivery = delivery;
//        }
//    }
//
//
//    @GetMapping("/view/{ticketId}")
//    public String view(@PathVariable("ticketId") long ticketId, ModelMap model)
//            throws TicketNotFound {
//        Ticket ticket = ticketService.getTicket(ticketId);
//        model.addAttribute("ticketId", ticketId);
//        model.addAttribute("ticket", ticket);
//        return "ticket/view";
//    }
//
//
//
//    @ExceptionHandler({TicketNotFound.class, AttachmentNotFound.class})
//    public ModelAndView error(Exception e) {
//        return new ModelAndView("error", "message", e.getMessage());
//    }
//
//    @GetMapping("/delete/{ticketId}")
//    public String deleteTicket(@PathVariable("ticketId") long ticketId) throws TicketNotFound {
//        ticketService.delete(ticketId);
//        return "redirect:/ticket/list";
//    }
//
//    @GetMapping("/{ticketId}/delete/{attachment:.+}")
//    public String deleteAttachment(@PathVariable("ticketId") long ticketId, @PathVariable("attachment")UUID attachmentId)
//            throws TicketNotFound, AttachmentNotFound {
//        ticketService.deleteAttachment(ticketId, attachmentId);
//        return "redirect:/ticket/view/" + ticketId;
//    }
//
//    @GetMapping("/edit/{userId}")
//    public ModelAndView showEdit(@PathVariable("userId") long userId,
//                                 Principal principal, HttpServletRequest request)
//            throws TicketNotFound {
//        User user = userService.getUser(userId);
//        if (user == null
//                || (!request.isUserInRole("ROLE_ADMIN")
//                && !principal.getName().equals(user.getUserName()))) {
//            return new ModelAndView(new RedirectView("/user/edit", true));
//        }
//        ModelAndView modelAndView = new ModelAndView("user/edit");
//        modelAndView.addObject("user",user);
//        UserForm userForm = new UserForm();
//        userForm.setUsername(user.getUsername());
//        userForm.setPassword(user.getPassword());
//        userForm.setConfirmpassword(user.getConfirmpassword());
//        userForm.setFullname(user.getFullname());
//        userForm.setEmail(user.getEmail());
//        userForm.setDelivery(user.getDelivery());
//        modelAndView.addObject("userForm", userForm);
//        return modelAndView;
//    }
//    @PostMapping("/edit/{userId}")
//    public String edit(@PathVariable("userId") long userId, UserForm form,
//                       Principal principal, HttpServletRequest request)
//            throws IOException, TicketNotFound {
//        User user = userService.getUser(userId);
//        if (user == null
//                || (!request.isUserInRole("ROLE_ADMIN")
//                && !principal.getName().equals(user.getUserName()))) {
//            return "redirect:/user/list";
//        }
//        userService.updateUser(userId, form.getUsername(), form.getPassword(), form.getConfirmpassword(), form.getFullname(), form.getEmail(), form.getDelivery());
//        return "redirect:/ticket/list/";
//    }
//}