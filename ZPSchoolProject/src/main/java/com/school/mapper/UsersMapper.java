package com.school.mapper;

import com.school.dto.UsersDto;
import com.school.entity.Users;

public class UsersMapper {

    public static UsersDto mappedToUserDTO (UsersDto userDto, Users users){

        userDto.setPersonId(users.getPersonId());
        userDto.setName(users.getName());
        userDto.setGender(users.getGender());
        userDto.setEmailId(users.getEmailId());
        userDto.setMobileNumber(users.getMobileNumber());
        userDto.setDateOfBirth(users.getDateOfBirth());
        userDto.setAddress(users.getAddress());
        return userDto;
    }
    public static Users mappedToUser (UsersDto userDto, Users users){

        users.setPersonId(userDto.getPersonId());
        users.setName(userDto.getName());
        users.setGender(userDto.getGender());
        users.setEmailId(userDto.getEmailId());
        users.setMobileNumber(userDto.getMobileNumber());
        users.setDateOfBirth(userDto.getDateOfBirth());
        users.setAddress(userDto.getAddress());
        return users;
    }
}
