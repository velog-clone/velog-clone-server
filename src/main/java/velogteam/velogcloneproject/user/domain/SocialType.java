package velogteam.velogcloneproject.user.domain;

import lombok.Getter;

@Getter
public enum SocialType {
    GOOGLE("google"),
    GITHUB("github");

    private String name;

    SocialType(String name){
        this.name=name;
    }
}
