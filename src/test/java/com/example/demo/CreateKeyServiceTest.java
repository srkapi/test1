package com.example.demo;

import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.mapper.MapperDomainKey;
import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import com.example.demo.application.port.out.CreateKeyPort;
import com.example.demo.application.service.CreateKeyService;
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
public class CreateKeyServiceTest {
    @Mock
    private CreateKeyPort createKeyPort;
    @Mock
    private MapperDomainKey mapperDomain;

    @InjectMocks
    @Spy
    private CreateKeyService createKeyService;

    @Test
    public void givenCreateKeyCommandWhenCallAddKeyThenReturnResponseCreateKey() {
        //given
        CreateKeyCommand createKeyCommand = mock(CreateKeyCommand.class);
        Key key = mock(Key.class);
        ResponseCreateKey responseCreateKey = mock(ResponseCreateKey.class);
        doReturn(key).when(mapperDomain).toDomain(createKeyCommand);
        doReturn(key).when(createKeyPort).save(key);
        doReturn(responseCreateKey).when(mapperDomain).toResponse(key);
        //when
        ResponseCreateKey serviceResponse = createKeyService.addKey(createKeyCommand);
        //then
        assertNotNull(serviceResponse);
        assertEquals(responseCreateKey,serviceResponse);
        verify(mapperDomain,times(1)).toDomain(createKeyCommand);
        verify(createKeyPort,times(1)).save(key);
        verify(mapperDomain,times(1)).toResponse(key);
    }
}
