package ru.gb.RickAndMortyAPI.domain;

import lombok.Data;

import java.util.List;

/**
 * Класс ответа API (списка объектов)
 */
@Data
public class Characters {
     Info info;
     List<Result> results;
}
