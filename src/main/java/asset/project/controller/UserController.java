package asset.project.controller;

import java.util.List;
import java.util.UUID;

import asset.project.UserLoginRequest;
import asset.project.dto.auth.UserLoginResponse;
import asset.project.security.JwtService;
import asset.project.security.UserPrincipal;
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
    JwtService jwtService;

    @PostMapping
    UUID createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    List<User> getUsers(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        return userService.getAll(offset, limit);
    }

    @PostMapping("/login")
    UserLoginResponse loginUser(@RequestBody UserLoginRequest userLogin) {
        User user = userService.login(userLogin.getMail(), userLogin.getPassword());
        System.out.println("here");
        return UserLoginResponse.builder()
                .userId(user.getId())
                .departmentId(user.getDepartment().getId())
                .token(jwtService.generateToken(user.getId(), user.getEmail(), user.getRole().name()))
                .role(user.getRole().name())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
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