package velogteam.velogcloneproject.security.oauth2.user;

import java.util.Map;

public class GithubOAuth2Userinfo extends OAuth2UserInfo{
    public GithubOAuth2Userinfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}
