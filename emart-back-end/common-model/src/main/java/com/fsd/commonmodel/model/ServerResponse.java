package com.fsd.commonmodel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerResponse<T> {

    private int code;
    private String msg;
    private T data;

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> successWithDefaultCode(T data) {
        return new ServerResponse<>(200001, "success", data);
    }

    public static <T> ServerResponse<T> error(T data, int code) {
        return new ServerResponse<>(code, "error", data);
    }

    public static <T> ServerResponse<T> errorWithMsg(int code, String msg, T data) {
        return new ServerResponse<>(code, msg, data);
    }

}
