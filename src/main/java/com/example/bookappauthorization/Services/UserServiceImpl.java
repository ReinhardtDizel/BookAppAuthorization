package com.example.bookappauthorization.Services;

import com.example.bookappauthorization.Model.Role;
import com.example.bookappauthorization.Model.User;
import com.example.bookappauthorization.Repositories.RoleRepository;
import com.example.bookappauthorization.Repositories.UserRepository;
import com.example.bookappauthorization.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User: " + username + " not Found ");
        }
        return user;
    }

    @Override
    public User saveUser(User user) {
        User userFromDB = userRepository.findAllByUsername(user.getUsername());

        if (userFromDB != null) {
            return null;
        }

        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void delete(String id) throws UsernameNotFoundException{
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        throw new UsernameNotFoundException("User: " + id + " not Found ");
    }

    @Override
    public User findUserById(String id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new User());
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }


}
