package com.hanjx369.demo.domain;

import com.hanjx369.demo.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 寒江雪
 * @createDate 2024-05-29 23:43
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private Boolean success;

    private Integer code;

    private T data;

    private String message;

    /**
     * 成功
     *
     * @param <T> 泛型
     * @return Result
     */
    public static <T> Result<T> success() {
        return new Result<>(true, ResultEnum.SUCCESS.getCode(), null, ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 成功
     *
     * @param data 返回值
     * @param <T>  泛型
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(true, ResultEnum.SUCCESS.getCode(), data, ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 成功
     *
     * @param data    返回值
     * @param message 提示消息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(true, ResultEnum.SUCCESS.getCode(), data, message);
    }

    /**
     * 失败
     *
     * @param <T> 泛型
     * @return Result
     */
    public static <T> Result<T> fail() {
        return new Result<>(false, ResultEnum.FAIL.getCode(), null, ResultEnum.FAIL.getMsg());
    }

    /**
     * 失败
     *
     * @param message 提示消息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(false, ResultEnum.FAIL.getCode(), null, message);
    }
}
