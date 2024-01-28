package ru.gb.RickAndMortyAPI.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации приложения
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class AppConfig {
    /**
     * Строка подключения к API
     */
    private String urlApi;
}
