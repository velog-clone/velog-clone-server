package velogteam.velogcloneproject.user.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import velogteam.velogcloneproject.user.domain.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoSaveResponse {
    private String name;
    private String email;
    private String idString;
    private String simpleIntroduction;

    @Builder
    public UserInfoSaveResponse(String name, String email, String idString, String simpleIntroduction) {
        this.name = name;
        this.email = email;
        this.idString = idString;
        this.simpleIntroduction = simpleIntroduction;
    }

    public UserInfoSaveResponse(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.idString = user.getIdString();
        this.simpleIntroduction = user.getSimpleIntroduction();
    }
}
