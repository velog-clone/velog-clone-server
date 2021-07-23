package velogteam.velogcloneproject.post.controller;

import com.nimbusds.oauth2.sdk.auth.JWTAuthentication;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import velogteam.velogcloneproject.post.controller.dto.PostCreateRequest;
import velogteam.velogcloneproject.post.controller.dto.PostCreateResponse;
import velogteam.velogcloneproject.post.service.PostService;
import velogteam.velogcloneproject.security.CurrentUser;

import javax.validation.Valid;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RequiredArgsConstructor
@RestController("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostCreateResponse> createPost(@AuthenticationPrincipal JWTAuthentication principal,
                                                         @Valid @RequestBody PostCreateRequest request){
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodCall(on(PostController.class)
                .createPost(principal,request))
                .build();
        return ResponseEntity
                .created(uriComponents.toUri())
                .body(postService.createPost(1L, request));
    }

//    @GetMapping("/posts")
//    public ResponseEntity<PostResponse> getPosts(){
//
//    }

    @GetMapping("/post")
    public ResponseEntity<PostCreateResponse> getPost(){
        throw new NotYetImplementedException();
    }

    @PutMapping("/post/{post_id}")
    public ResponseEntity<PostCreateResponse> updatePost(){
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/post/{post_id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post_id")Long postId){
        postService.deletePost(postId);
        return ResponseEntity
                .noContent()
                .build();
    }
}
