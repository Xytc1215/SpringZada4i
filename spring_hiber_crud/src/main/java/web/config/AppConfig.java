package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Основной конфигурационный класс Spring MVC.
 * Отвечает за настройку веб-контекста без использования XML.
 */
@Configuration
@EnableWebMvc
@ComponentScan("web.controller")
@PropertySource("classpath:db.properties")

public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry r) {
        r.jsp("/WEB-INF/views/",".jsp");
    }
}

