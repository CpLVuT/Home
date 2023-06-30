package com.example.familytree.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -6433659870842666438L;
    private final static String RESPONSE_TYPE = "application/json;charset=utf-8";
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public ResponseResult(T data) {
        this.code = 10000;
        this.msg = "";
        this.data = data;
    }

    public ResponseResult() {
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(10000, "", data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>(10000, message, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(Integer code, T data, String message) {
        return new ResponseResult<T>(code, message, data);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<T>(50000, message, null);
    }




    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}