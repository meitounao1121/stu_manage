package com.example.stu_manage.exception;
 /* 功能描述: 建立自定义异常类 -- 继承运行异常最高类
 *
 */


public class MyException extends RuntimeException{

    public MyException(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
