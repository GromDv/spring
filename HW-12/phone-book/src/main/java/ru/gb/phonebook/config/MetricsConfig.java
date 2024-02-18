package ru.gb.phonebook.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации Micrometer
 */
@Configuration
public class MetricsConfig {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * Создаём свой таймер
     * @param meterRegistry
     * @return
     */
    @Bean
    public Timer mytimer(MeterRegistry meterRegistry) {
        return Timer.builder("user_my_timer")
                .description("my own timer")
                .register(meterRegistry);
    }

    /**
     * Создаём свой счетчик
     * @param meterRegistry
     * @return
     */
    @Bean
    public Counter myCounter(MeterRegistry meterRegistry) {
        return Counter.builder("abonents_counter")
                .description("Number of abonents")
                .register(meterRegistry);
    }
}
