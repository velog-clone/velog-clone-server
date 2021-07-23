package velogteam.velogcloneproject.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import velogteam.velogcloneproject.exception.IdNotFoundException;
import velogteam.velogcloneproject.post.controller.dto.PostCreateRequest;
import velogteam.velogcloneproject.post.controller.dto.PostCreateResponse;
import velogteam.velogcloneproject.post.domain.Post;
import velogteam.velogcloneproject.post.domain.PostRepository;
import velogteam.velogcloneproject.security.CurrentUser;
import velogteam.velogcloneproject.user.domain.User;
import velogteam.velogcloneproject.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public PostCreateResponse createPost(Long userId, PostCreateRequest reqDto) {
        Post post = PostCreateRequest.toEntity(reqDto);
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("존재하지 않는 유저입니다."));
        post.setAuthor(user);
        Post savedPost = postRepository.save(post);
        return new PostCreateResponse(savedPost.getId());
    }

//    @Transactional
//    public PostResponse getPosts(){
//
//    }

    @Transactional
    public void deletePost(Long postId){
        Post post = findPostById(postId);
        postRepository.delete(post);
    }

    @Transactional
    public Post findPostById(Long postId){
        return postRepository.findById(postId).orElseThrow(
                ()->new IdNotFoundException("존재하지 않는 포스트입니다.")
        );
    }
}
