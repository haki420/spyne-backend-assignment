package Services;

import Models.User;
import Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    public void followUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId).orElseThrow();
        User followed = userRepository.findById(followedId).orElseThrow();
        follower.getFollowers().add(followed);
        userRepository.save(follower);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}