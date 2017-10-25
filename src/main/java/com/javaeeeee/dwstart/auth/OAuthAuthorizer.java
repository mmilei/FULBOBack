package com.javaeeeee.dwstart.auth;

import com.javaeeeee.dwstart.core.User;
import io.dropwizard.auth.Authorizer;

public class OAuthAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {
        return role.equals(user.getRol());
    }
}
