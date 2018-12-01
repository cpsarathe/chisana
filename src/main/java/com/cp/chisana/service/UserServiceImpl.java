package com.cp.chisana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cp.chisana.dao.UserRepository;
import com.cp.chisana.domain.User;
import com.cp.chisana.dto.UserDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */
@Service("chUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO add(UserDTO userDTO) {
        User user = this.convertUserDTOToUser(userDTO);
        user = (User)userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public void delete(UserDTO userDTO) {

    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    private User convertUserDTOToUser(UserDTO dto){
        User user = new User();
        Date date = Calendar.getInstance().getTime();
        user.setActiveFlg((byte)1);
        user.setAppName(dto.getAppName());
        user.setCreatedDate(date);
        user.setEmailId(dto.getEmail());
        user.setUpdatedDate(date);
        return user;
    }
}
