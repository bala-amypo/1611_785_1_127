// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody AuthRequest request) {
//         return userService.registerCustomer(
//                 request.getFullName(),
//                 request.getEmail(),
//                 request.getPassword()
//         );
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {
//         User user = userService.findByEmail(request.getEmail());

//         String token = jwtUtil.generateToken(
//                 user.getEmail(),
//                 user.getRole().name(),
//                 user.getId()
//         );

//         return new AuthResponse(token);
//     }
// }
