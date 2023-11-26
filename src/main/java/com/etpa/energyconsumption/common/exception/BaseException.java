package com.etpa.energyconsumption.common.exception;

public class BaseException extends RuntimeException {
    private final String key;

    public BaseException(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String getMessage() {
        return "Exception occurred " + key;
    }

}
