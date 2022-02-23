package com.Testers;
import com.Administrations.UserAdministration;
import com.DataHelpers.UserDataHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.Normal.User;

@RestController
@RequestMapping("/users")
public class UserTesting {
    private UserDataHelper udh = new UserDataHelper();
    private UserAdministration ua = new UserAdministration();
    @GetMapping("{username}")
    public ResponseEntity<User> getStudentPath(@PathVariable(value = "username") String username) {
        User user = null;
                for(User u : udh.getUsers()) {
                    if(u.Username() == username) {
                        user = u;
                    }
                }

        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (!ua.addUser(user)){
            String entity =  "User with username " + user.Username() + " already exists.";
            return new ResponseEntity(entity,HttpStatus.CONFLICT);
        } else {
            String url = "user" + "/" + user.Username(); // url of the created user
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }

    }

    @DeleteMapping("{username}")
    public ResponseEntity deletePost(@PathVariable String username) {
        User user = null;
        for(User u : udh.getUsers()) {
            if(u.Username() == username) {
                user = u;
            }
        }
        ua.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
