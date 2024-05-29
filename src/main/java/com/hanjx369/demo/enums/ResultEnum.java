package com.hanjx369.demo.enums;

import lombok.Getter;

/**
 * @author 寒江雪
 * @createDate 2024-05-29 23:44
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "成功"),

    FAIL(400, "失败");

    private final int code;

    private final String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
