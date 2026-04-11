package asset.project.service;

import asset.project.entity.User;
import asset.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public UUID save(User user) {
        return userRepository.save(user).getId();
    }

    public List<User> getAll(int offset, int limit) {
        return userRepository.findAll(PageRequest.of(offset/limit, limit)).toList();
    }

    public User login(String email, String password) {
        if (email == null || password == null) {
            return null;
        }
        User user =userRepository.getUserByEmail(email);
        if (user == null) {
            return null;
        }
        if(password.equals(user.getPassword_hash())) {
            return user;
        }
        return null;
    }
}
