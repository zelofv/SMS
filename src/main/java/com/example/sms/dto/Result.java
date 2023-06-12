package com.example.ketangpai.dto;

import lombok.Data;

/**
 * @author 名称
 * @date 2022/8/28 22:07
 */
@Data
public class Result<T> {
    public static final int SUCCESS = 200;
    public static final int UN_LOGIN = 401;
    public static final int NO_PERMISSION = 402;
    public static final int INFORMATION_IS_OUTDATED = 403;

    public static final int PARAMETER_VERIFICATION_FAILED = 405;

    public static final int HAVE_JOINED = 410;
    public static final int ERROR = 500;
    private int status;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
