package com.javacamp.hrms.business.concretes;

import com.javacamp.hrms.business.abstracts.EmployerService;
import com.javacamp.hrms.core.utilities.results.*;
import com.javacamp.hrms.dataAccess.abstracts.EmployerDao;
import com.javacamp.hrms.entities.abstracts.User;
import com.javacamp.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(
                employerDao.findAll(),
                "Employers displayed."
        );
    }

    @Override
    public Result add(Employer employer) {
        if(isMailExists(employer)) {
            return new ErrorResult("E-mail is already in use.");
        }
        employerDao.save(employer);
        return new SuccessResult("Employer is successfully added.");
    }

    private boolean isMailExists(User user) {
        return employerDao.findByEmail(user.getEmail()).isPresent();
    }
}
