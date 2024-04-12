package hkmu.comps380f.controller;

import hkmu.comps380f.dao.UserManagementService;
import hkmu.comps380f.form.UserForm;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class IndexController {

    @Resource
    private UserManagementService umService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "redirect:/ticket/list";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "appUser", new UserForm());
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("appUser") UserForm form)
            throws IOException {
        String[] roles = new String[]{"ROLE_USER"};
        form.setRoles(roles);
        umService.createAppUser(form.getUsername(), passwordEncoder.encode(form.getPassword()), form.getConfirmpassword(), form.getFullname(), form.getEmail(), form.getDelivery(), form.getRoles());
        logger.info("User " + form.getUsername() + " created.");
        return "redirect:/login";
    }

}
