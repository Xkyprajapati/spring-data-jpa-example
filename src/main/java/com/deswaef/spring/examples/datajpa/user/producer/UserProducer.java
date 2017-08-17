package com.deswaef.spring.examples.datajpa.user.producer;

import com.deswaef.spring.examples.datajpa.user.model.User;
import com.deswaef.spring.examples.datajpa.user.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * User: Quinten
 * Date: 30-4-2014
 * Time: 14:24
 *
 * @author Quinten De Swaef
 */
@RestController
public class UserProducer {
    private Log logger = LogFactory.getLog(UserProducer.class);


    @Autowired
    private UserService userService;

    @Autowired
    public UserProducer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void produceData() {
        findUsers();
        addOneUser();
    }
    
    @RequestMappping(value="/adduser", Method="RequestMethod.POST")
    public void addUser(User user){
        userSercice.addUser();
        
    }
//     private void addOneUser() {
//         logger.info("-> Adding new user now!");
//         userService.addUser(new User("Quinten", "SecretPassword"));
//     }
    
    @RequestMapping(values="/findbyid/{id}", Method="RequestMethod.GET")
    private void findUsers(@PathVariable int id) {
        logger.info("Trying to find all users.");
        userService.findUsers(id);
        
        
        
        
//         List<User> allUsers = userService.getAllUsers();
//         if(allUsers.isEmpty()) {
//             logger.info("--No users found--");
//         } else {
//             for (User foundUser : allUsers) {
//                 logger.info(String.format("user with id %d and name %s found :)", foundUser.getId(), foundUser.getName()));
//             }
//         }
    }
}
