package se.racemates.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;


public class TestOAuth2AuthenticationManager extends OAuth2AuthenticationManager {

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        return new TestOAuth2Authentication();
    }
}
