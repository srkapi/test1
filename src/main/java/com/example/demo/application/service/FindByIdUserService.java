package com.example.demo.application.service;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
import com.example.demo.application.port.in.usecases.FindByIdUserUseCases;
import com.example.demo.application.port.out.FindByIdUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByIdUserService implements FindByIdUserUseCases {
    final static Logger logger = Logger.getLogger(FindByIdUserService.class);
    private final FindByIdUserPort findByIdUserPort;
    private final MapperDomainUser mapperDomainUser;

    @Override
    public ResponseFindByIdUser getById(Long id) {
        UserDomain userDomain = this.findByIdUserPort.findById(id);
        return this.mapperDomainUser.toResponseById(userDomain);
    }
}
