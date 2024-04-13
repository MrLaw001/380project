package hkmu.comps380f.controller;


import hkmu.comps380f.dao.UserManagementService;
import hkmu.comps380f.form.UserForm;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserManagementController {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private UserManagementService umService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("user/add", "appUser", new UserForm());
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("appUser") UserForm form)
            throws IOException {
        umService.createAppUser(form.getUsername(), passwordEncoder.encode(form.getPassword()),
                form.getConfirmpassword(), form.getFullname(),
                form.getEmail(), form.getDelivery(), form.getRoles());
        logger.info("User " + form.getUsername() + " created.");
        return "redirect:/user/list";
    }

    @GetMapping({"", "/", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("appUsers", umService.getAppUsers());
        return "user/list";
    }
    @GetMapping("/delete/{username}")
    public String deleteAppUser(@PathVariable("username") String username) {
        umService.delete(username);
        logger.fatal("User " + username + " deleted.");
        return "redirect:/user/list";
    }

    @GetMapping("/edit")
    public ModelAndView edit() {
        return new ModelAndView("user/edit", "appUser", new UserForm());
    }

}

