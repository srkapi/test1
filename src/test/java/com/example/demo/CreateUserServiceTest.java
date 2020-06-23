package com.example.demo;

import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.service.adapter.SendMailVerificationPort;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.out.PersistenceUserPort;
import com.example.demo.application.service.CreateUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {
    @Mock
    private AuthorityRepository authorityRepository;
    @Mock
    private PersistenceUserPort persistenceUserPort;
    @Mock
    private SendMailVerificationPort sendMailVerificationPort;
    @Mock
    private MapperDomainUser mapperDomain;

    @InjectMocks
    @Spy
    private CreateUserService createUserService;

    @Test
    public void givenCreateUserCommandWhenCallAddUserThenReturnResponseCreateUser() {
        //given
        UserDomain userDomain = mock(UserDomain.class);
        CreateUserCommand createUserCommand = mock(CreateUserCommand.class);
        ResponseCreateUser responseCreateUser = mock(ResponseCreateUser.class);
        doReturn(userDomain).when(mapperDomain).toDomain(createUserCommand);
        doReturn(userDomain).when(persistenceUserPort).save(userDomain, createUserCommand);
        doNothing().when(sendMailVerificationPort).sendMail(userDomain);
        doReturn(responseCreateUser).when(mapperDomain).toResponse(userDomain);
        //when
        ResponseCreateUser serviceResponse = createUserService.addUser(createUserCommand);

        //then
        assertNotNull(serviceResponse);
        assertEquals(responseCreateUser, serviceResponse);
        verify(mapperDomain, times(1)).toDomain(createUserCommand);
        verify(persistenceUserPort, times(1)).save(userDomain, createUserCommand);
        verify(sendMailVerificationPort, times(1)).sendMail(userDomain);
        verify(mapperDomain, times(1)).toResponse(userDomain);
    }
}
