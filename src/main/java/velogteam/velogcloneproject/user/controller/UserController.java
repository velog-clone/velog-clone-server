package velogteam.velogcloneproject.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import velogteam.velogcloneproject.user.controller.dto.UserInfoSaveRequest;
import velogteam.velogcloneproject.user.controller.dto.UserInfoSaveResponse;
import velogteam.velogcloneproject.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @GetMapping("/test")
    public String oAuth2Login(String code) {
        return code;
    }

    @GetMapping("/api")
    public String oAuthApi(@RequestParam("string") String str) {
        return str;
    }

    @GetMapping("/api/annotation")
    public String oAuthApiForAnnotation(@AuthenticationPrincipal(expression = "id") Long id) {
        return String.valueOf(id);
    }

    public ResponseEntity<UserInfoSaveResponse> initializeUserInfo(@AuthenticationPrincipal(expression = "id") Long userId,
                                                                   UserInfoSaveRequest request) {
        UserInfoSaveResponse response = userService.registerUserInfo(userId, request);

        return ResponseEntity.ok(response);
    }
}
