package kz.narhoz.springlab.service;

import kz.narhoz.springlab.Repository;
import kz.narhoz.springlab.RoleRepository;
import kz.narhoz.springlab.model.Role;
import kz.narhoz.springlab.User;
import kz.narhoz.springlab.RoleRepository;
import kz.narhoz.springlab.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private Repository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(List.of(roleRepository.getById(1L)))); // USER
        userRepository.save(user);
    }
}
