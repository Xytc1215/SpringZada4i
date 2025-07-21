package koschei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс Spring.
 * Определяет, какие бины будут использоваться в приложении.
 */

@Configuration
@ComponentScan(basePackages = "koschei")
public class AppConfig {
}