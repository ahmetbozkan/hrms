package com.javacamp.hrms.core.adapters;

import com.javacamp.hrms.business.validation.EmailVerificationService;
import org.springframework.stereotype.Component;

@Component("real_email_verification_service")
public class EmailVerificationAdapter implements EmailVerificationService {

    @Override
    public void sendVerificationEmail(String receiver, String message) {
        // This is the real e-mail verification manager, real verification e-mail will be sent through this class.
        System.out.println(message + "is sent to the " + receiver + " by real e-mail service.");
    }

    @Override
    public boolean isVerificated() {
        return false;
    }
}
