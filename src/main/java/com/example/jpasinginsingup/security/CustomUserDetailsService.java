package com.example.jpasinginsingup.security;

import com.example.jpasinginsingup.dao.UserDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findUserByUsername(username)
                .map(SecurityUser::new)
                //.map(u -> new SecurityUser(u)) // same as this -> .map(SecurityUser::new)
                .orElseThrow(EntityNotFoundException::new);
    }
}
