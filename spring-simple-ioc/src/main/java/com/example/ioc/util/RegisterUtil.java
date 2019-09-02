package com.example.ioc.util;

import com.example.ioc.Register;

public class RegisterUtil {

    public static Register getRegister() {
        return Register.getInstance();
    }
}
