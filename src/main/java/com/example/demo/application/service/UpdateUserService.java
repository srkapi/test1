package com.example.demo.application.service;

import com.example.demo.adapter.in.web.UserController;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
import com.example.demo.application.port.in.usecases.UpdateUserUseCases;
import com.example.demo.application.port.out.UpdateUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCases {
    final static Logger logger = Logger.getLogger(UpdateUserService.class);
    private final UpdateUserPort updateUserPort;
    private final MapperDomainUser mapperDomainUser;

    @Override
    public ResponseCreateUser updateUser(ResponseFindByIdUser responseFindByIdUser, Long id) {
        UserDomain userDomain = this.mapperDomainUser.toDomainById(responseFindByIdUser);
        UserDomain user = this.updateUserPort.update(userDomain, id);
        return this.mapperDomainUser.toResponse(user);
    }
}
