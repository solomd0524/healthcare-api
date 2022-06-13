package com.simplilearn.healthcareapi.users;

import com.simplilearn.healthcareapi.users.exceptions.UserIsNotAdminException;
import com.simplilearn.healthcareapi.users.exceptions.UserLogInFailedException;
import com.simplilearn.healthcareapi.users.exceptions.UserNameNotFoundException;
import com.simplilearn.healthcareapi.users.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void deleteUserByUserId(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(id);
        } else {
            userRepository.deleteById(id);
        }
    }

    public User createUser(UserEntity userEntity) throws UserNotFoundException {
        UserEntity userEntityCreated = userRepository.save(userEntity);
        return UserMapper.MAPPER.map(userRepository.getUserByUserId(userEntityCreated.getUserId())
                .orElseThrow(() -> new UserNotFoundException(userEntityCreated.getUserId())));
    }

    public String getUserLogin(String userName, String password) {
        User user = UserMapper.MAPPER.map(userRepository.getUserByUserNameAndPassword(userName, password)
                .orElseThrow(() -> new UserLogInFailedException(userName, password)));

        return "Welcome to your dashboard " + user.getFirstName() + " " + user.getLastName() + ".";
    }

    public String getAdminLogin(String userName) {
        User user = getUserByPassword(userName);
        if (Objects.isNull(user)) throw new UserNameNotFoundException(userName);

        UserEntity userEntity = userRepository.findById(user.getUserId()).orElse(null);
        boolean adminMatch = userEntity.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equalsIgnoreCase("admin"));

        if (adminMatch) {
            return "Welcome " + userEntity.getFirstName() + " " + userEntity.getLastName() + ". You are logged in as Admin.";
        } else {
            throw new UserIsNotAdminException(userEntity.getUserName());
        }
    }

    private User getUserByPassword(String userName) {
        List<User> user = UserMapper.MAPPER.map(userRepository.getUserByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName)));
        return user.stream().findFirst().orElse(null);
    }

    public UserProfile getUserProfileByUserId(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(user)) throw new UserNotFoundException(userId);
        return setUserProfile(user);
    }

    private UserProfile setUserProfile(UserEntity user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(user.getUserId());
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());
        userProfile.setEmailAddress(user.getEmailAddress());
        userProfile.setUserName(user.getUserName());
        userProfile.setPassword(user.getPassword());
        return userProfile;
    }

    public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
        UserEntity user = userRepository.findById(id).orElse(null);
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setAddress(userProfile.getAddress());
        user.setEmailAddress(userProfile.getEmailAddress());
        user.setUserName(userProfile.getUserName());
        user.setPassword(userProfile.getPassword());
        userRepository.save(user);

        return userProfile;
    }
}
