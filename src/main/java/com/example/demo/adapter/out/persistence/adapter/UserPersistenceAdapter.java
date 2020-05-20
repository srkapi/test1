package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.out.persistence.mapper.MapperPersistenceUser;
import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.persistence.repository.UserRepository;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.out.ActivateUserPort;
import com.example.demo.application.port.out.FindByIdUserPort;
import com.example.demo.application.port.out.PersistenceUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements PersistenceUserPort, FindByIdUserPort, ActivateUserPort {
    final static Logger logger = Logger.getLogger(UserPersistenceAdapter.class);
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final MapperPersistenceUser mapperPersistence;


    @Override
    public UserDomain save(UserDomain userDomain, CreateUserCommand createUserCommand) {
        List<Long> roles = createUserCommand.getRol();
        Collection<Authority> authorityCollection = new ArrayList<Authority>();
        List<String> namesAuthorityList = new ArrayList<>();
        for (Long rol : roles) {
            Authority authority = this.authorityRepository.findById(rol).orElseThrow(() -> new EntityNotFoundException());
            authorityCollection.add(authority);
            String nameAuthority = authority.getName();
            namesAuthorityList.add(nameAuthority);
            userDomain.addAuthority(nameAuthority);
        }
        User user = this.mapperPersistence.toModelPersistence(userDomain, authorityCollection);
        User savedUser = this.userRepository.save(user);
        return this.mapperPersistence.toDomain(savedUser);
    }

    @Override
    public UserDomain findById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        User user = userOptional.get();
        return this.mapperPersistence.toDomain(user);
    }

    @Override
    public UserDomain activateUser(UserDomain userDomain, Long id) {
        //search authority by name
        List<String> authoritiesStrings = userDomain.getAuthorities();
        Collection<Authority> authoritiesCollection = new ArrayList<>();
        for (String nameAuthority : authoritiesStrings) {
            Authority authority = this.authorityRepository.findByNameAuthority(nameAuthority);
            authoritiesCollection.add(authority);
        }
        User user = this.mapperPersistence.toModelPersistenceActivate(userDomain, authoritiesCollection);
        user.setId(id);
        User updatedUser = this.userRepository.save(user);
        return this.mapperPersistence.toDomain(updatedUser);
    }
}
