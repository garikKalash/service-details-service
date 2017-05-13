package com.soso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by Garik Kalashyan on 5/13/2017.
 */

@Repository
public class ModeResolver {
    private final String mode;


    @Autowired
    public ModeResolver(@Value("${applicationmode}") String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
