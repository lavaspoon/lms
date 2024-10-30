package lava.lms.controller;

import lava.lms.config.JwtUtil;
import lava.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/home")
    public String home(@RequestParam("userid") String username) {
        return userRepository.findByUsername(username)
                .map(user -> jwtUtil.generateToken(user.getUsername()))
                .orElse("User not found");
    }

    @GetMapping("/test")
    public String getProtectedData() {
        return "이 데이터는 인증된 사용자만 접근할 수 있습니다.";
    }
}