package Springboot_Maven_Oracle.services;

import Springboot_Maven_Oracle.domain.User;

import java.util.List;

public interface UserServices {

    List<User> findAllUsers();
    String saveUser(User user);
    String update(User user);
    User findById(Integer id);
    void delete(Integer id);
}
