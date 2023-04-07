package init.incidence.comun.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageConfiguration {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        Locale.setDefault(Locale.ENGLISH);
        messageSource.setBasenames("classpath:/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}

