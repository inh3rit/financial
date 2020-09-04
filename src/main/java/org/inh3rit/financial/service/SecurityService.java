package org.inh3rit.financial.service;

import org.inh3rit.financial.dao.SecurityMapper;
import org.inh3rit.financial.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    public void add(List<Security> securityList) {
        securityMapper.batchInsert(securityList);
    }
}