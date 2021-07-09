package velogteam.velogcloneproject.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    @ResponseBody
    @GetMapping("/auth/google/callback")
    public String Oauth2Login( String code) {
        return code;
    }
}
