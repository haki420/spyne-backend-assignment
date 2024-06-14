package Controllers;

import Models.User;
import Services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent() && new BCryptPasswordEncoder().matches(user.getPassword(), existingUser.get().getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String name) {
        return userService.searchUsersByName(name);
    }

    @PostMapping("/follow")
    public void followUser(@RequestParam Long followerId, @RequestParam Long followedId) {
        userService.followUser(followerId, followedId);
    }
}