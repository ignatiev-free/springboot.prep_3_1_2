package com.prep.springboot.prep.service;

import com.prep.springboot.prep.model.User;
import com.prep.springboot.prep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return userRepository.getReferenceById((long) id);
    }


    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userRepository.existsById((long) id);
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById((long) id);
    }
}
