package com.xmlproject.xmlproject.UserRepo;

import com.xmlproject.xmlproject.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

     List<User> getByFname(String fname);
     List<User> getByLname(String lname);
}
