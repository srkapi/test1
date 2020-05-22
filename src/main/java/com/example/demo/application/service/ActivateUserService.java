package com.example.demo.application.service;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
import com.example.demo.application.port.in.usecases.ActivateUserUseCases;
import com.example.demo.application.port.in.usecases.FindByIdUserUseCases;
import com.example.demo.application.port.out.ActivateUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivateUserService implements ActivateUserUseCases {
    final static Logger logger = Logger.getLogger(ActivateUserService.class);
    private final FindByIdUserUseCases findByIdUserUseCases;
    private final ActivateUserPort activateUserPort;
    private final MapperDomainUser mapperDomainUser;

    @Override
    public ResponseCreateUser activateUser(Long id) {
        ResponseFindByIdUser responseFindByIdUser = this.findByIdUserUseCases.getById(id);
        UserDomain userDomain = this.mapperDomainUser.toDomainById(responseFindByIdUser);
        userDomain.setEnabled(true);
        UserDomain user = this.activateUserPort.activateUser(userDomain, id);

        return this.mapperDomainUser.toResponse(user);
    }
}
