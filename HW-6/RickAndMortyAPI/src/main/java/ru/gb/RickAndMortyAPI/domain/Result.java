package ru.gb.RickAndMortyAPI.domain;

import lombok.Data;

import java.util.Date;

/**
 * Класс объекта персонажа
 */
@Data
public class Result {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private Date created;
}
