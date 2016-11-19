package se.racemates.security;


import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import static se.racemates.security.TestOAuth2Authentication.END_USER_TOKEN;

public class TestTokeStore extends InMemoryTokenStore {


    private static final OAuth2AccessToken ACCESS_TOKEN = new OAuth2AccessToken() {
        @Override
        public Map<String, Object> getAdditionalInformation() {
            return null;
        }

        @Override
        public Set<String> getScope() {
            return null;
        }

        @Override
        public OAuth2RefreshToken getRefreshToken() {
            return null;
        }

        @Override
        public String getTokenType() {
            return null;
        }

        @Override
        public boolean isExpired() {
            return false;
        }

        @Override
        public Date getExpiration() {
            return new Date(Long.MAX_VALUE);
        }

        @Override
        public int getExpiresIn() {
            return Integer.MAX_VALUE;
        }

        @Override
        public String getValue() {
            return END_USER_TOKEN;
        }
    };


    @Override
    public OAuth2AccessToken readAccessToken(final String tokenValue) {

        if (END_USER_TOKEN.equals(tokenValue)) {
            return ACCESS_TOKEN;
        }

        throw new RuntimeException("Unknown token: " + tokenValue);
    }

    @Override
    public OAuth2Authentication readAuthentication(final String token) {
        return new TestOAuth2Authentication();
    }
}
