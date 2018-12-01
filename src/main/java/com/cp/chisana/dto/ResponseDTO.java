package com.cp.chisana.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean success = Boolean.TRUE;
    private int status = 200;
    private String message;
    private T body;
}
