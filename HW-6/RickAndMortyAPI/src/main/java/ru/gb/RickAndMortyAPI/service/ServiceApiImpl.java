package ru.gb.RickAndMortyAPI.service;

import lombok.AllArgsConstructor;
import ru.gb.RickAndMortyAPI.config.AppConfig;
import ru.gb.RickAndMortyAPI.domain.Characters;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.RickAndMortyAPI.domain.Result;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi{
    private RestTemplate template;
    private HttpHeaders headers;
    private final AppConfig appConfig;

    /**
     * Получение всего списка персонажей
     * @return
     */
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(appConfig.getUrlApi(), HttpMethod.GET,entity, Characters.class);

        return response.getBody();
    }

    /**
     * Получение персонажа по id
     * @param id
     * @return
     */
    public Result getCharacter(Long id) {
        String urlApi = appConfig.getUrlApi() + "/" + id.toString();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<?> response = template.exchange(urlApi, HttpMethod.GET, entity, Result.class);

        return (Result) response.getBody();
    }
}
