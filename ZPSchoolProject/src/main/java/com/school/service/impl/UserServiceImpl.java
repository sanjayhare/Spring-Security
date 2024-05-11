package com.school.service.impl;

import com.school.dto.UsersDto;
import com.school.entity.Users;
import com.school.exception.CustomerAlreadyExistsException;
import com.school.exception.ResourceNotFoundException;
import com.school.mapper.UsersMapper;
import com.school.repository.UserRepository;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UsersDto getUserDetails(String userID) {
        boolean isUpdated = false;
        Users user = userRepository.findById(Integer.parseInt(userID)).orElseThrow(() -> new ResourceNotFoundException("User", "UserID", userID));
        UsersDto usersDto = UsersMapper.mappedToUserDTO(new UsersDto(), user);
        return usersDto;
    }

    @Override
    public void createUser(Users user) {
        Optional<Users> optionalUsers = userRepository.findByMobileNumberOrEmailId(user.getMobileNumber(), user.getEmailId());
        if (optionalUsers.isPresent() == true && optionalUsers.get().getMobileNumber().equalsIgnoreCase(user.getMobileNumber())) {
            throw new CustomerAlreadyExistsException("User already registered with given mobileNumber : " + user.getMobileNumber());
        } else if (optionalUsers.isPresent() == true && optionalUsers.get().getEmailId().equalsIgnoreCase(user.getEmailId())) {
            throw new CustomerAlreadyExistsException("User already registered with given EmailId: " + user.getEmailId());
        }
        userRepository.save(user);
    }

    @Override
    public boolean updateUser(UsersDto userDto) {
        boolean isUpdated = false;
        Users existingUser = userRepository.findById(userDto.getPersonId()).orElseThrow(() -> new ResourceNotFoundException("User", "UserID", String.valueOf(userDto.getPersonId())));
        if (existingUser != null) {

            Users user = UsersMapper.mappedToUser(userDto, existingUser);
            userRepository.save(user);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteUser(String userID) {
        boolean isDeleted = false;
        Users existingUser = userRepository.findById(Integer.parseInt(userID)).orElseThrow(() -> new ResourceNotFoundException("User", "UserID", userID));
        if (existingUser != null) {
            userRepository.deleteById((Integer.parseInt(userID)));
            isDeleted = true;
        }
        return isDeleted;


    }
}
