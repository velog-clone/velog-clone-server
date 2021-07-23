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
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(name = "id_str")
    private String idString;

    @NotNull
    private String email;

    @Column(name = "page_title")
    private String pageTitle;

    @Column(name = "social_info")
    private String socialInfo;

    @Column(name = "simple_introduction")
    private String simpleIntroduction;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String providerId;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new LinkedHashSet<>();

    @Builder
    public User(Long id, String name,String password, String email, String pageTitle,
                String socialInfo, String simpleIntroduction, Role role,
                SocialType socialType, String providerId) {
        this.id = id;
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

    public void userInfoRegister(String name, String idString, String simpleIntroduction){
        this.name = name;
        this.idString = idString;
        this.simpleIntroduction = simpleIntroduction;
    }

    public void removePost(Post post){
        posts.remove(post);
    }
}
