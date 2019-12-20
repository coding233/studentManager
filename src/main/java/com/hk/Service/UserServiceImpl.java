package com.hk.Service;

import com.hk.Dao.UserRepository;
import com.hk.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User CheckUser(String uname, String password) {
        User user=userRepository.findByUnameAndPassword(uname, password);
        return user;
    }

    @Transactional
    @Override
    public User insUser(User user) {
        return userRepository.save(user);
    }
}
