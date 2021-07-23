package velogteam.velogcloneproject.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import velogteam.velogcloneproject.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TokenProbviderTest {
    @Autowired
    private TokenProvider tokenProvider;

    String token;

    @BeforeAll
    void setup(){
        User user = User.builder()
                .id(1L)
                .email("test@email.com")
                .name("testuser")
                .build();
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        Authentication authentication = new TestingAuthenticationToken(userPrincipal,"testcredential");
        token = tokenProvider.createToken(authentication);
    }


    @Test
    void 토큰생성검증(){
        assertThat(tokenProvider.validateToken(token)).isTrue();
    }
    @Test
    void 토큰userId획득검증(){
        assertThat(tokenProvider.getUserIdFromToken(token)).isEqualTo(1L);
    }
}
