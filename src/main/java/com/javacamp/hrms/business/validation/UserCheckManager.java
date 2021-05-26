package com.javacamp.hrms.business.validation;

import com.javacamp.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Component;

@Component("fake_mernis_service")
public class UserCheckManager implements UserCheckService {

    @Override
    public boolean isRealCandidate(Candidate candidate) {
        return true;
    }
}
