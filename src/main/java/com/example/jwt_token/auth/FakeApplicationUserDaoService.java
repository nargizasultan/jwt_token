package com.example.jwt_token.auth;

import com.example.jwt_token.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.jwt_token.security.ApplicationUserRole.*;
@Repository("fake")
@RequiredArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(STUDENT.getGrantedAuthorities(), "annasmith",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(ADMIN.getGrantedAuthorities(), "linda",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(ADMINTRAINEE.getGrantedAuthorities(), "tom",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true)
        );
        return applicationUsers;
    }
}
