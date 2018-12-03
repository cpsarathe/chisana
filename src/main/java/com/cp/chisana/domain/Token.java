package com.cp.chisana.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by Chandra.Sarathe on 12/1/2018.
 */

@Data
@Entity
@Table(name = "CH_TOKEN")
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "CHANNEL")
    protected String channel;

    @Column(name = "ACTIVE_FLG")
    protected Byte activeFlg;

    @Column(name = "EXPIRED_DATE")
    protected Date expiredDate;

    @Column(name = "TOKEN")
    protected String token;

    @Column(name = "CHANNEL_TYPE")
    protected String channelType;

    @Column(name = "USER_ID")
    protected Long userId;

    @Column(name = "VALIDATED_FLG")
    protected byte validatedFlg;

    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @Column(name = "UPDATED_DATE")
    protected Date updatedDate;

}
