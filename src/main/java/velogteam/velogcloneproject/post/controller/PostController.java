package velogteam.velogcloneproject.post.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import velogteam.velogcloneproject.post.controller.dto.PostCreateRequest;
import velogteam.velogcloneproject.post.controller.dto.PostCreateResponse;
import velogteam.velogcloneproject.post.service.PostService;

import javax.validation.Valid;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RequiredArgsConstructor
@RestController("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/user/{user_id}/post")
    public ResponseEntity<PostCreateResponse> createPost(@PathVariable("user_id") Long userId,
                                                         @Valid @RequestBody PostCreateRequest reqDto){
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodCall(on(PostController.class)
                .createPost(userId,reqDto))
                .build();
        return ResponseEntity
                .created(uriComponents.toUri())
                .body(postService.createPost(userId, reqDto));
    }

    @GetMapping("/user/{user_id}/post")
    public ResponseEntity<PostCreateResponse> getPost(){
        throw new NotYetImplementedException();
    }

    @PutMapping("/user/{user_id}/post/{post_id}")
    public ResponseEntity<PostCreateResponse> updatePost(){
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/user/{user_id}/post/{post_id}")
    public ResponseEntity<PostCreateResponse> deletePost(){
        throw new NotYetImplementedException();
    }
}
