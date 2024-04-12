package hkmu.comps380f.dao;


import hkmu.comps380f.model.AppUser;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserManagementService {
    @Resource
    private AppUserRepository appUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional
    public void createAppUser(String username, String password,String confirmpassword,String fullname, String email, String delivery, String[] roles) {
        AppUser user = new AppUser(username, password,confirmpassword, fullname,email,delivery, roles);
        appUserRepo.save(user);
    }

    @Transactional
    public List<AppUser> getAppUsers() {
        return appUserRepo.findAll();
    }

    @Transactional
    public void delete(String username) {
        AppUser appUser = appUserRepo.findById(username).orElse(null);
        if (appUser == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        appUserRepo.delete(appUser);
    }

    @Transactional
    @PostConstruct
    public void init() {
        if (appUserRepo.count() == 0){
            AppUser user = new AppUser("keith", passwordEncoder.encode("keithpw"),"keithpw","LEE Lap Kei","lklee@hkmu.edu.hk","Hong Kong Metropolitan University", new String[]{"ROLE_ADMIN", "ROLE_USER"});
            appUserRepo.save(user);
        }
    }
}

