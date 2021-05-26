package com.javacamp.hrms.business.validation;

import org.springframework.stereotype.Component;

@Component("fake_email_verification_service")
public class EmailVerificationManager implements EmailVerificationService {

    @Override
    public void sendVerificationEmail(String receiver, String message) {
        // This is a fake e-mail verification manager for testing purposes, no e-mail will be sent through this class.
        System.out.println(message + "is sent to the " + receiver + " by fake service.");
    }

    @Override
    public boolean isVerificated() {
        return true;
    }
}
