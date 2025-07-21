package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс-инициализатор, заменяющий web.xml.
 * Настраивает конфигурацию сервлетов и указывает корневой URL ("/") для приложения.
 */

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // корневой контекст не используется
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // подключаем WebConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // корневая точка входа
    }
}
