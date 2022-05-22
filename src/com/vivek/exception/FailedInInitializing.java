package com.vivek.exception;

public class FailedInInitializing extends Exception {

    public String getMessage() {

        return "failed to initialized";
    }

}
