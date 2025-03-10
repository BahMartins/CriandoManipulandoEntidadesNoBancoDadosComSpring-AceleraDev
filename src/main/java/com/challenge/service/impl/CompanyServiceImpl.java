package com.challenge.service.impl;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepository.findByAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return companyRepository.save(object);
    }
}
