package com.cp.chisana.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonRawValue;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */

@Data
@EqualsAndHashCode(of = {"USER_ID"})
@Entity
@Table(name = "CH_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long userId;

    @Column(name = "EMAIL_ID")
    protected String emailId;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Column(name = "MOBILE_NUMBER")
    protected String mobileNumber;

    @Column(name = "GENDER")
    protected String gender;

    @Column(name = "ACTIVE_FLG")
    protected byte activeFlg;

    @Column(name = "APP_NAME")
    protected String appName;

    @Column(name = "PASSWORD")
    protected String password;

    @Column(name = "CREATED_BY")
    protected String createdBy;

    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @Column(name = "UPDATED_DATE")
    protected Date updatedDate;

    @Column(name = "UPDATED_BY")
    protected Date updatedBy;


}
