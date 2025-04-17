package com.hw.service;

import com.hw.model.dto.Security;
import com.hw.repository.SecurityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    private final SecurityRepository securityRepository = new SecurityRepository();

    public List<Security> getAllSecurities() {
        return securityRepository.getAllSecurities();
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteSecurity(id);
    }
}
