package velogteam.velogcloneproject.post.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import velogteam.velogcloneproject.post.domain.Post;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private Boolean displaySetting;

    @NotNull
    private String urlSetting;

    private String thumbnail;

    @Builder
    public PostCreateRequest(String title, String content, Boolean displaySetting,
                             String urlSetting, String thumbnail) {
        this.title = title;
        this.content = content;
        this.displaySetting = displaySetting;
        this.urlSetting = urlSetting;
        this.thumbnail = thumbnail;
    }

    public static Post toEntity(PostCreateRequest reqDto){
        return Post.builder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .urlSetting(reqDto.getUrlSetting())
                .displaySetting(reqDto.getDisplaySetting())
                .thumbnail(reqDto.getThumbnail())
                .build();
    }
}
