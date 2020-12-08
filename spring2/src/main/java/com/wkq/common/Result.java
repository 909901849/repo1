package com.wkq.common;

import lombok.Data;

@Data
public class Result<T> {
    private int status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

//    成功的时候返回
    public static Result success (ResultEnum re) {
        return new Result(re.getStatus(), re.getMsg());
    }
    public static<T> Result<T> success(ResultEnum re ,T data){
        return new Result<>(re.getStatus(),re.getMsg(),data);
    }

//    失败的时候返回
    public static Result error (ResultEnum re) {
        return new Result(re.getStatus(), re.getMsg());
    }
}
