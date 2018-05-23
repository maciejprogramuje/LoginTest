package com.maciejprogramuje.facebook.logintest;

/**
 * Created by m.szymczyk on 2018-03-14.
 */

public class ErrorResponse {
    public String error;
    public String code;

    //{"code":101,"error":"Invalid username/password."}

    @Override
    public String toString() {
        return error;
    }
}
