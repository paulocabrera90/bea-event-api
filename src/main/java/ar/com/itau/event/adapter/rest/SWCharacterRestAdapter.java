package ar.com.itau.event.adapter.rest;

import ar.com.itau.event.adapter.rest.exception.BadRequestRestClientException;
import ar.com.itau.event.adapter.rest.exception.TimeoutRestClientException;
import ar.com.itau.event.adapter.rest.handler.RestTemplateErrorHandler;
import ar.com.itau.event.adapter.rest.model.SWCharacterRestModel;
import ar.com.itau.event.application.port.out.SWCharacterRepository;
import ar.com.itau.event.config.Config;
import ar.com.itau.event.config.ErrorCode;
import ar.com.itau.event.config.exception.NotFoundException;
import ar.com.itau.event.domain.SWCharacter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class SWCharacterRestAdapter implements SWCharacterRepository {

    private final RestTemplate restTemplate;
    private final Config config;

    public SWCharacterRestAdapter(final RestTemplate restTemplate, final Config config) {
        final Map<HttpStatus, RuntimeException> errorMap = new HashMap<>();
        errorMap.put(HttpStatus.BAD_REQUEST, new BadRequestRestClientException(ErrorCode.CHARACTER_BAD_REQUEST));
        errorMap.put(HttpStatus.NOT_FOUND, new NotFoundException(ErrorCode.CHARACTER_NOT_FOUND));
        errorMap.put(HttpStatus.GATEWAY_TIMEOUT, new TimeoutRestClientException(ErrorCode.CHARACTER_TIMEOUT));
        restTemplate.setErrorHandler(new RestTemplateErrorHandler(Collections.unmodifiableMap(errorMap)));

        this.restTemplate = restTemplate;
        this.config = config;
    }

    @Override
    public SWCharacter getById(int id) {
        final String url = config.getCharacterRepository().getUrl().replace("{id}", String.valueOf(id));
        log.info("Getting Star Wars character with ID {}", id);
        return Optional.ofNullable(restTemplate.getForObject(url, SWCharacterRestModel.class))
                .map(model -> {
                    log.info("Got Star Wars character model {}", model);
                    return model.toDomain();
                })
                .orElseThrow(() -> new NotFoundException(ErrorCode.RESOURCE_NOT_FOUND));
    }

}
