package com.javaeeeee.dwstart.auth;

import java.util.Optional;
import java.util.UUID;

import com.javaeeeee.dwstart.core.AccessToken;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.AccessTokenDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import org.joda.time.DateTime;
import org.joda.time.Duration;

public class OAuthAuthenticator implements Authenticator<String, User> {

    public static final int ACCESS_TOKEN_EXPIRE_TIME_MIN = 300;
    private AccessTokenDAO accessTokenDAO = new AccessTokenDAO();

    @Override

    public Optional<User> authenticate(String accessTokenId) throws AuthenticationException {
        // Check input, must be a valid UUID
        UUID accessTokenUUID;
        try {
            accessTokenUUID = UUID.fromString(accessTokenId);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }

        // Get the access token from the database
        Optional<AccessToken> accessToken;
        accessToken = accessTokenDAO.findAccessTokenById(accessTokenUUID);

        if (accessToken == null || !accessToken.isPresent()) {
            return Optional.empty();
        }

        // Check if the last access time is not too far in the past (the access token is expired)
        // BORRAR ESTA PRIMER LINEA QUE HACE QUE NO TOME EN CUENTA EL TOKEN DEFAULT ni Tokens
        // de admin
        if (!accessToken.get().equals(UUID.fromString("9fdfe272-8528-43f4-bd34-12324199a348"))
                && !accessToken.get().getUser().getRol().equals("ADMIN")) {
            DateTime today = new DateTime();
            Duration duration = new Duration(accessToken.get().getLastAccessUTC(), today);
            if (duration.getStandardMinutes() > ACCESS_TOKEN_EXPIRE_TIME_MIN) {
                return Optional.empty();
            }
        }

        // Update the access time for the token
        accessTokenDAO.setLastAccessTime(accessTokenUUID, new DateTime());

        // Return the user's id for processing
        //return Optional.of(accessToken.get().getUserId());
        return Optional.of(accessToken.get().getUser());
    }
}