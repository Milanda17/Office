package Springboot_Maven_Oracle.services.Impl;

import Springboot_Maven_Oracle.domain.User;
import Springboot_Maven_Oracle.repositories.UserRepositories;
import Springboot_Maven_Oracle.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServicesImpl implements UserServices {


    @Autowired
    private UserRepositories userRepositories;


    @Override
    public List<User> findAllUsers() {
       List<User>allusers= userRepositories.findAll();

       return allusers;
    }

    @Override
    public String saveUser(User user) {

        userRepositories.save(user);
        return "Data Saved";
    }

    @Override
    public String update(User user) {

        if (user.getId()!=null){
            userRepositories.save(user);
            return "Data Updated";

        }else{
            return "Error";
        }

    }

    @Override
    public User findById(Integer id) {

      return userRepositories.getOne(id);

    }

    @Override
    public void delete(Integer id) {
        userRepositories.deleteById(id);
    }
}
