package firstweb.project;

import firstweb.project.models.AuthenticationBean;
import firstweb.project.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {
        @Autowired
        private  UserRepository userRepository;
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome </h1>");
    }
        @GetMapping("/users")
      public List<Users> retriveAllUsers(){
           return userRepository.findAll();
        }
        @DeleteMapping("/users/{id}")
        public ResponseEntity<Object> deleteUser(@PathVariable int id){
            userRepository.deleteById(id);
            return ResponseEntity.accepted().build();
        }
        @PostMapping("/users")
        public ResponseEntity<Object> createUser(@RequestBody Users users) {
            Users newUser = userRepository.save(users);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newUser.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
//    @RequestMapping("/user")
//    public Principal user(Principal user) {
//        return user;
//    }
        @GetMapping(path = "/auth")
        public AuthenticationBean auth(){
        return  new AuthenticationBean("You are authenticated!");
        }
}