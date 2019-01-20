package com.xmlproject.xmlproject.Controller;
import com.xmlproject.xmlproject.Models.User;
import com.xmlproject.xmlproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(path = "/add", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public User savePerson(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public List<User> getAll() throws IOException {
        return userService.userList();
    }

    @RequestMapping(path = "/get/fname/{fname}", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public List<User> getUserByName(@PathVariable String fname) throws FileNotFoundException {
       return userService.getByFname(fname);
    }
    @RequestMapping(path = "/get/lname/{lname}", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public List<User> getUserByLname(@PathVariable String lname) throws FileNotFoundException {
        return userService.getByLname(lname);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public void userDelete(@PathVariable Long id){
         userService.deleteById(id);
    }
}
