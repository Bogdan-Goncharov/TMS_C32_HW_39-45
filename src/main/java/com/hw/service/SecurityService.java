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

    public Security getSecurityById(Long id) {
        return securityRepository.getSecurityById(id);
    }

    public void addSecurity(Security security) {
        securityRepository.saveSecurity(security);
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteSecurity(id);
    }
}
