package asset.project.controller;

import java.util.List;
import java.util.UUID;

import asset.project.service.UserService;
import asset.project.entity.User;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    UUID createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    List<User> getUsers(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        return userService.getAll(offset, limit);
    }

    @PostMapping("/login")
    User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService
                .login(email,password);
    }

//    @GetMapping("/{userId}")
//    User getUser(@PathVariable("userId") String userId) {
//    }
//
//    @GetMapping("/my-info")
//    User getMyInfo() {
//
//    }
//
//    @DeleteMapping("/{userId}")
//    User deleteUser(@PathVariable String userId) {
//
//    }
//
//    @PutMapping("/{userId}")
//    User updateUser(@PathVariable String userId) {
//
//    }
}