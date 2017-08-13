package com.example.rohanmalik.finalmovie.model;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class SessionIDmodal {
    private Boolean success;
    private String session_id;

    public SessionIDmodal(Boolean success, String session_id) {
        this.success = success;
        this.session_id = session_id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
