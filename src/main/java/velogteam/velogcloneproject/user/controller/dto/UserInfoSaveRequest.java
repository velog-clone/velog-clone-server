package velogteam.velogcloneproject.user.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoSaveRequest {
    private String name;
    private String idString;
    private String simpleIntroduction;

    @Builder
    public UserInfoSaveRequest(String name, String idString, String simpleIntroduction) {
        this.name = name;
        this.idString = idString;
        this.simpleIntroduction = simpleIntroduction;
    }
}
