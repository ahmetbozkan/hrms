package com.javacamp.hrms.business.validation;

public interface EmailVerificationService {

    void sendVerificationEmail(String receiver, String message);
    boolean isVerificated();
}
