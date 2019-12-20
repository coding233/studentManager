package com.hk.Dao;

import com.hk.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUnameAndPassword(String uname,String password);

}
