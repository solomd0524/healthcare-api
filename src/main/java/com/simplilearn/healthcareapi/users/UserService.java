package com.simplilearn.healthcareapi.users;

import com.simplilearn.healthcareapi.users.exceptions.UserIsNotAdminException;
import com.simplilearn.healthcareapi.users.exceptions.UserLogInFailedException;
import com.simplilearn.healthcareapi.users.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public String getUserLogin(String userName, String password) {
        User user = UserMapper.MAPPER.map(userRepository.getUserByUserNameAndPassword(userName, password)
                .orElseThrow(() -> new UserLogInFailedException(userName, password)));

        return "Welcome to your dashboard " + user.getFirstName() + " " + user.getLastName() + ".";
    }

    public String getAdminLogin(String userName) {
        List<User> users = UserMapper.MAPPER.map(userRepository.getUserByUserName(userName));
        User admin = users.stream().filter(user -> user.getIsAdmin().equals("true"))
                .collect(Collectors.toList())
                .stream().findFirst()
                .orElse(null);

        if (Objects.isNull(admin)) {
            throw new UserIsNotAdminException(userName);
        }
        return "Welcome " + admin.getFirstName() + " " + admin.getLastName() + ". You are logged in as Admin.";
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
