package com.cp.chisana.service;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cp.chisana.dao.TokenRepository;
import com.cp.chisana.dao.UserRepository;
import com.cp.chisana.domain.Token;
import com.cp.chisana.domain.User;
import com.cp.chisana.dto.Email;
import com.cp.chisana.dto.UserDTO;
import com.cp.chisana.utils.TokenChannelEnum;
import com.cp.chisana.utils.Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */
@Service("chUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Resource(name="chEmailService")
    private EmailService emailService;

    @Value("${user.token.expiry.duration.days}")
    private int userTokenExpiryDays;

    /**
     * generates apiKey to be used by user
     * register user
     * generate and save token
     * send email
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO add(UserDTO userDTO) {
        String apiKey = Utilities.getApiKey();
        userDTO.setKey(apiKey);
        User user = this.convertUserDTOToUser(userDTO);
        user = (User)userRepository.save(user);
        userDTO.setUserId(user.getUserId());

        Token token = buildToken(user);
        tokenRepository.save(token);


        Email email = new Email();
        email.setToEmail(user.getEmailId());
        email.setSubject("Chisana New User Registration Email Verification");
        email.setBody("Chisana New User Registration Email Verification");
        emailService.sendSimpleMessage(email);
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
        user.setApiKey(dto.getKey());
        return user;
    }

    /**
     * we assume default channel type is email
     * @param user
     * @return
     */
    private Token buildToken(User user){
        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setChannel(user.getEmailId());
        token.setChannelType(TokenChannelEnum.EMAIL.name());
        token.setUserId(user.getUserId());
        token.setActiveFlg((byte)1);
        token.setValidatedFlg((byte)0);
        Date date = Calendar.getInstance().getTime();
        token.setCreatedDate(date);
        token.setUpdatedDate(date);
        date = DateUtils.addDays(date,userTokenExpiryDays);
        token.setExpiredDate(date);
        return token;
    }
}
