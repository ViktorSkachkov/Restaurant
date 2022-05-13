package com.example.demo.Testers;

/*@RestController
@RequestMapping("/users")
public class UserTesting {
    private UserDataHelper udh = new UserDataHelper();
    private UserAdministration ua = new UserAdministration(udh);
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
}*/
