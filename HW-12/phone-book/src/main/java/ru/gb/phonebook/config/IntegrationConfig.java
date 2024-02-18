package ru.gb.phonebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * Класс конфигурации Spring integration
 */
@Configuration
public class IntegrationConfig {
    /**
     * Входной канал Spring integration
     *
     * @return
     */
    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    /**
     * Выходной канал Spring integration
     *
     * @return
     */
    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    /**
     * Блок преобразования(логики)
     *
     * @return
     */
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
            //какая-то логика
            return text;
        };
    }

    /**
     * Хэндлер выходного канала
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "./files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
