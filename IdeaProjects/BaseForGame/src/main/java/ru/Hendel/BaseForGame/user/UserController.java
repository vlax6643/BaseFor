package ru.Hendel.BaseForGame.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/getUserByLogin/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userRepository.findByUsername(login).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/createUserByLogin")
    public User createUserByLogin(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }


    @DeleteMapping("/deleteUserByLogin/{login}")
    public String deleteUserByLogin(@PathVariable String login) {
        User user = userRepository.findByUsername(login).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return "User deleted successfully";
    }

    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUser(@PathVariable Long id){
        try {
            User existingUser =userRepository.findById(id).get();
            userRepository.deleteById(id);
            return "User deleted";
        } catch (Exception e){
            return "user not found";
        }


    }
}
