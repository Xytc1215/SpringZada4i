package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Конфигурация и инициализация веб-приложения.
 * Класс заменяет web.xml и настраивает два контекста:
 * <ul>
 *     <li>Root Application Context — для инфраструктуры (DAO, JPA, сервисы)</li>
 *     <li>Servlet Application Context — для Spring MVC (контроллеры, view resolver)</li>
 * </ul>
 * DispatcherServlet будет обрабатывать все запросы ("/").
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Возвращает классы конфигурации корневого контекста приложения (бизнес-логика, JPA, транзакции и т.д.).
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                HibernateConfig.class
        };
    }

    /**
     * Возвращает классы конфигурации Spring MVC (веб-контроллеры, view-resolver и пр.).
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                AppConfig.class
        };
    }

    /**
     * Указывает, какие URL-адреса будет обрабатывать DispatcherServlet.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
