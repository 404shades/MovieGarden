package com.example.rohanmalik.finalmovie.model;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class RequestToken {
    private Boolean success;
    private String request_token;

    public RequestToken(Boolean success, String request_token) {
        this.success = success;
        this.request_token = request_token;
    }

    public Boolean getSuccess() {
        //Sucess
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }
}
