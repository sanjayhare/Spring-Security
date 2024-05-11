package com.school.service;

import com.school.dto.UsersDto;
import com.school.entity.Users;
import jakarta.validation.Valid;

public interface UserService {

    UsersDto getUserDetails(String userID);

    public void createUser(Users users);

    public boolean updateUser(UsersDto userDto);

    public boolean deleteUser(String userID);

}
