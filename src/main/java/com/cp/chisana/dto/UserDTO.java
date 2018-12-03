package com.cp.chisana.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Chandra.Sarathe on 11/18/2018.
 */
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String appDomainUrl;
    private String key;
    private String email;
    private String appName;

    @JsonIgnore
    private Long userId;
}
