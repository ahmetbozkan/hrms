package com.javacamp.hrms.core.adapters;

import com.javacamp.hrms.business.validation.UserCheckService;
import com.javacamp.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Component;

@Component("real_mernis_service")
public class MernisServiceAdapter implements UserCheckService {

    @Override
    public boolean isRealCandidate(Candidate candidate) {
        // Candidate will be checked through real mernis service (Eski C# Yayını dk. 45)
        // (KPSSoapClient object -> client.TCKimlikDogrula()
        return true;
    }
}
