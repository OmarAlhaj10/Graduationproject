package com.gymapp.service.impl;

import com.gymapp.dao.UserDao;
import com.gymapp.domain.Role;
import com.gymapp.service.UserDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        com.gymapp.domain.User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        session.removeAttribute("id");
        session.removeAttribute("userName");
        session.setAttribute("id", user.getIdUser());
        session.setAttribute("userName", user.getName() + " " + user.getLastname());
        
        var roles = new ArrayList<GrantedAuthority>();
        for (Role rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }
        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
