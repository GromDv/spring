package ru.gb.demoJPA.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Вспомогательный класс сообщений о результате запроса
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResult {

    private int statusCode;
    private String message;
}
