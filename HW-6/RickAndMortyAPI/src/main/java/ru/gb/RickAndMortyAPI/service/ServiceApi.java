package ru.gb.RickAndMortyAPI.service;

import ru.gb.RickAndMortyAPI.domain.Characters;
import ru.gb.RickAndMortyAPI.domain.Result;

/**
 * Интерфейс API
 */
public interface ServiceApi {
    Characters getAllCharacters();
    Result getCharacter(Long id);
}
