package com.simplilearn.healthcareapi.users;

import com.simplilearn.healthcareapi.users.exceptions.UserIsNotAdminException;
import com.simplilearn.healthcareapi.users.exceptions.UserLogInFailedException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserService.class})
@Tag("UnitTest")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;


    private static final String USERNAME = "dsol";
    private static final String PASSWORD = "happy1";
    private static final UserProjection userProjection = new UserProjectionStub();
    private static final User user = new UserStub();
    private static final UserEntity userEntityAdmin = new UserEntityAdminStub();
    private static final UserEntity userEntityUser = new UserEntityUserStub();
    private static final List<User> userList = Collections.singletonList(user);
    private static final List<UserProjection> userProjectionlist = Collections.singletonList(userProjection);

    @Test
    void whenGetByUserNameAndPassword_thenReturnRetrieved() {

        given(userRepository.getUserByUserNameAndPassword(anyString(), anyString())).willReturn(Optional.of(userProjection));
        given(userMapper.map(userProjection)).willReturn(user);
        String result = userService.getUserLogin(USERNAME, PASSWORD);

        assertThat(result).isNotNull();

        verify(userRepository, times(1)).getUserByUserNameAndPassword(anyString(), anyString());
    }

    @Test
    void whenGetUserByUserNameAndPassword_whereNoUserIsFound_thenThrowException() {
        given(userRepository.getUserByUserNameAndPassword(anyString(), anyString())).willReturn(Optional.empty());
        assertThrows(UserLogInFailedException.class, () -> userService.getUserLogin(USERNAME, PASSWORD));
    }

    @Test
    void whenGetByAdminLoginByPassword_whereUserIsAdmin_thenReturnRetrieved() {

        given(userRepository.getUserByUserName(anyString())).willReturn(Optional.of(userProjectionlist));
        given(userMapper.map(userProjectionlist)).willReturn(userList);
        given(userRepository.findById(anyLong())).willReturn(Optional.of(userEntityAdmin));

        String result = userService.getAdminLogin(USERNAME);

        assertThat(result).isNotNull();

        verify(userRepository, times(1)).getUserByUserName(anyString());
    }

    @Test
    void whenGetByAdminLoginByPassword_whereUserIsNotAdmin_thenReturnRetrieved() {

        given(userRepository.getUserByUserName(anyString())).willReturn(Optional.of(userProjectionlist));
        given(userMapper.map(userProjectionlist)).willReturn(userList);
        given(userRepository.findById(anyLong())).willReturn(Optional.of(userEntityUser));
        assertThrows(UserIsNotAdminException.class, () -> userService.getAdminLogin(anyString()));
    }
}