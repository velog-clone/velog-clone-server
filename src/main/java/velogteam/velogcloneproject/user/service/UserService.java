package velogteam.velogcloneproject.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import velogteam.velogcloneproject.exception.IdNotFoundException;
import velogteam.velogcloneproject.exception.RegisteredUserInfoException;
import velogteam.velogcloneproject.user.controller.dto.UserInfoSaveRequest;
import velogteam.velogcloneproject.user.controller.dto.UserInfoSaveResponse;
import velogteam.velogcloneproject.user.domain.User;
import velogteam.velogcloneproject.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserInfoSaveResponse registerUserInfo(Long userId, UserInfoSaveRequest reqDto){
        User user = findUserById(userId);
        checkRegistration(user);
        user.userInfoRegister(reqDto.getName(), reqDto.getIdString(), reqDto.getSimpleIntroduction());
        return new UserInfoSaveResponse(user);
    }

    @Transactional
    public User findUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(
                ()->new IdNotFoundException("존재하지 않는 유저입니다.")
        );
    }

    private void checkRegistration(User user){
        if(StringUtils.hasText(user.getIdString())){
            throw new RegisteredUserInfoException("이미 정보를 설정하였습니다.");
        }
    }
}
