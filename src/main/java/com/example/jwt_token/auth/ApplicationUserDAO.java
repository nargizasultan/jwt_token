package com.example.jwt_token.auth;

import java.util.Optional;

public interface ApplicationUserDAO {
     Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
