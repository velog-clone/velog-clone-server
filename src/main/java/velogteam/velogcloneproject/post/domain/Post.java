package velogteam.velogcloneproject.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import velogteam.velogcloneproject.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private Boolean displaySetting;

    private String urlSetting;

    @Transient
    private String thumbnail;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastModified;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Post(String title, String content, Boolean displaySetting,
                String urlSetting, String thumbnail) {
        this.title = title;
        this.content = content;
        this.displaySetting = displaySetting;
        this.urlSetting = urlSetting;
        this.thumbnail = thumbnail;
    }

    public void setAuthor(User user){
        this.user = user;
        user.addPost(this);
    }
}
