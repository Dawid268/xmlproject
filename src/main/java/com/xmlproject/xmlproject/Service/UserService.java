package com.xmlproject.xmlproject.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.xmlproject.xmlproject.Models.User;
import com.xmlproject.xmlproject.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    XStream xstream = new XStream(new StaxDriver());
    PrintWriter writer;

    public List<User> userList() throws IOException {
        List<User> users = (List<User>) userRepository.findAll();
        writer = new PrintWriter("FindAll.xml");
        String dataXml = xstream.toXML(users);
        writer.write(dataXml);
        writer.close();

        return users;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getByFname(String fname) throws FileNotFoundException {
        List<User> usersByFname =userRepository.getByFname(fname);
        writer = new PrintWriter("FindByFname.xml");
        String dataXml = xstream.toXML(usersByFname);
        writer.write(dataXml);
        writer.close();
        return usersByFname;
    }
    public List<User> getByLname(String lname) throws FileNotFoundException {
        List<User> usersByLname =userRepository.getByLname(lname);
        writer = new PrintWriter("FindByLname.xml");
        String dataXml = xstream.toXML(lname);
        writer.write(dataXml);
        writer.close();
        return usersByLname;
    }
    public void deleteById(Long id){
          userRepository.deleteById(id);
    }
}

