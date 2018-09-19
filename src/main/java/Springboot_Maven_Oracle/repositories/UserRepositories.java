package Springboot_Maven_Oracle.repositories;

import Springboot_Maven_Oracle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Integer> {


}
