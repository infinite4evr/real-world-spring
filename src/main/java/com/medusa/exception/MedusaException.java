package com.medusa.exception;

public interface MedusaException {
    public String getMessage();
    public String getDetail();
    public int getStatus();
}