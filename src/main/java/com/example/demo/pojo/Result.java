package com.example.demo.pojo;

import java.io.Serializable;

public class Result implements Serializable {

    private boolean loginR = false;
    private String resultStr = "";

    public boolean isLoginR() {
        return loginR;
    }

    public void setLoginR(boolean loginR) {
        this.loginR = loginR;
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }
}
