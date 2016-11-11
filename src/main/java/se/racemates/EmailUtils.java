package se.racemates;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.Properties;

public class EmailUtils {

    private EmailUtils() {}

    public static SpringTemplateEngine getSpringTemplateEngineForEmail() {

        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(emailTemplateResolver());

        return templateEngine;
    }

    private static TemplateResolver emailTemplateResolver() {

        final TemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setPrefix("mail/");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(1);
        templateResolver.setCacheable(true);

        return templateResolver;
    }

    public static JavaMailSenderImpl getJavaMailSenderFromSettings(MailSettings mailSettings) {

        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailSettings.getHost());
        mailSender.setPort(mailSettings.getPort());
        mailSender.setUsername(mailSettings.getUsername());
        mailSender.setPassword(mailSettings.getPassword());

        final Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", mailSettings.isDebug());

        return mailSender;
    }
}
