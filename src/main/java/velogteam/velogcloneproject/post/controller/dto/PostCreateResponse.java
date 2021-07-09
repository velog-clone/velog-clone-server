package velogteam.velogcloneproject.post.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateResponse {
    private Long postId;

    public PostCreateResponse(Long postId) {
        this.postId = postId;
    }
}
