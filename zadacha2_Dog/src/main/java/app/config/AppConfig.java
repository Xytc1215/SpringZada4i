package app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс.
 * Указывает Spring, где искать компоненты.
 */

@Configuration
@ComponentScan(basePackages = "app")
public class AppConfig {
}
