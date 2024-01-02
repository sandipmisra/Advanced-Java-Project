package dev.service;

import dev.domain.User;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        user.setFullname(user.getFullname().toUpperCase());
        userRepository.create(user);
    }

    public User getUserById(int userId) {
        return userRepository.get(userId);
    }

    public void updateUser(User user) {
        userRepository.edit(user);
    }

    public User authenticate(String fullname, String password) {
        // Retrieve the user from the repository based on the provided credentials
        User user = userRepository.findByEmailAndPassword(fullname, password);

        // Return the authenticated user or null if authentication fails
        return user;
    }



}
