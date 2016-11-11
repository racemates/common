package se.racemates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailSettings {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final boolean debug;

    @Autowired
    public MailSettings(
            @Value("${mail.server.host}") final String host,
            @Value("${mail.server.port}") final int port,
            @Value("${mail.server.username}") final String username,
            @Value("${mail.server.password}") final String password,
            @Value("${mail.debug}") final boolean debug
    ) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.debug = debug;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isDebug() {
        return debug;
    }
}
