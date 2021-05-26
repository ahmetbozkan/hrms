package com.javacamp.hrms.business.concretes;

import com.javacamp.hrms.business.abstracts.CandidateService;
import com.javacamp.hrms.business.validation.EmailVerificationService;
import com.javacamp.hrms.business.validation.UserCheckService;
import com.javacamp.hrms.core.utilities.results.*;
import com.javacamp.hrms.dataAccess.abstracts.CandidateDao;
import com.javacamp.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final UserCheckService userCheckService;
    private final EmailVerificationService emailVerificationService;

    //@Qualifier is used for differentiate the classes that implements "UserCheckService" with a name. (Ex. fake_mernis_service)
    @Autowired
    public CandidateManager(CandidateDao candidateDao, @Qualifier("fake_mernis_service") UserCheckService userCheckService,
                            @Qualifier("real_email_verification_service") EmailVerificationService emailVerificationService) {
        this.candidateDao = candidateDao;
        this.userCheckService = userCheckService;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(
                candidateDao.findAll(),
                "Candidates displayed."
        );
    }

    @Override
    public Result add(Candidate candidate) {
        if (isMailExists(candidate.getEmail())) {
            return new ErrorResult("E-mail is already in use.");
        } else if (isIdentityNumberExists(candidate.getIdentityNumber())) {
            return new ErrorResult("Identity number is already in use");
        } else if (!userCheckService.isRealCandidate(candidate)) {
            return new ErrorResult("Not a valid person.");
        }

        candidateDao.save(candidate);
        emailVerificationService.sendVerificationEmail(
                candidate.getEmail(),
                "You can verificate your account with this link. "
        );

        return new SuccessResult("Candidate is successfully added. A verification e-mail is sent.");
    }

    private boolean isMailExists(String email) {
        return candidateDao.findByEmail(email).isPresent();
    }

    private boolean isIdentityNumberExists(String identityNumber) {
        return candidateDao.findByIdentityNumber(identityNumber).isPresent();
    }

}
