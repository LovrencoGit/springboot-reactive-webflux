package com.learn.springwebfluxdemo.response;

public class Response {

    private int code;
    private String message;
    private boolean error;

    public Response() {
        this.code = 0;
        this.message = "SUCCESS";
        this.error = false;
    }

    public Response(int code, String message, boolean error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
