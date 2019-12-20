package com.hk.Service;

import com.hk.po.User;

public interface UserService {
    User CheckUser(String uname, String password);
    User insUser(User user);
}
