package com.cp.chisana.service;

import com.cp.chisana.domain.User;
import com.cp.chisana.dto.UserDTO;

import java.util.List;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */
public interface UserService {

    UserDTO add(UserDTO userDTO) ;

    List<UserDTO> getAll();

    void delete(UserDTO userDTO);

    UserDTO update(UserDTO userDTO) ;

    boolean verifyToken(String token);

}
