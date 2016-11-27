package se.racemates.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class TestOAuth2Authentication extends OAuth2Authentication {

    public static final String END_USER_TOKEN = UUID.randomUUID().toString();

    private static final OAuth2Request request = new OAuth2Request(
            Collections.emptyMap(),
            "test-client",
            Collections.emptyList(),
            true,
            Collections.emptySet(),
            Collections.emptySet(),
            "test-url",
            Collections.emptySet(),
            Collections.emptyMap()
    );

    private final Map oauthDetails;


    TestOAuth2Authentication(final Map oauthDetails) {
        super(request, null);
        this.oauthDetails = oauthDetails;
    }

    @Override
    public Object getDetails() {
        return super.getDetails();
    }

    @Override
    public Authentication getUserAuthentication() {
        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return oauthDetails;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(final boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return null;
            }
        };
    }
}
