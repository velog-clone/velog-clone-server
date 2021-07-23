package velogteam.velogcloneproject.post.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponse {
    private String title;
    private String thumbnail;

    public PostResponse(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }
}
