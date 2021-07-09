package velogteam.velogcloneproject.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import velogteam.velogcloneproject.post.domain.Post;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
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

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String providerId;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new LinkedHashSet<>();

    @Builder
    public User(String name, String email, String password, String pageTitle, String socialInfo,
                String simpleIntroduction, Role role, SocialType socialType, String providerId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.pageTitle = pageTitle;
        this.socialInfo = socialInfo;
        this.simpleIntroduction = simpleIntroduction;
        this.role = role;
        this.socialType = socialType;
        this.providerId = providerId;
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void removePost(Post post){
        posts.remove(post);
    }
}
