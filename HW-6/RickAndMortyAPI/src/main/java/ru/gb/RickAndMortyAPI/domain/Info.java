package ru.gb.RickAndMortyAPI.domain;

import lombok.Data;

/**
 * Класс информации об ответе API
 */
@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
