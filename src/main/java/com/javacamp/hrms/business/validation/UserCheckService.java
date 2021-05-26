package com.javacamp.hrms.business.validation;

import com.javacamp.hrms.entities.concretes.Candidate;

public interface UserCheckService {

    boolean isRealCandidate(Candidate candidate);

}
