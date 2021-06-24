package velogteam.velogcloneproject.domain.users;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Column(name = "page_title")
    private String pageTitle;
    @Column(name = "social_info")
    private String socialInfo;
    @Column(name = "simple_introduction")
    private String simpleIntroduction;

    @Builder
    public User(String name, String email, String pageTitle,
                String socialInfo, String simpleIntroduction) {
        this.name = name;
        this.email = email;
        this.pageTitle = pageTitle;
        this.socialInfo = socialInfo;
        this.simpleIntroduction = simpleIntroduction;
    }

}
