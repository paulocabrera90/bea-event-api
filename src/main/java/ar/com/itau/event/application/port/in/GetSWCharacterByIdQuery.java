package ar.com.itau.event.application.port.in;

import ar.com.itau.event.domain.SWCharacter;

import java.util.concurrent.CompletionStage;

public interface GetSWCharacterByIdQuery {
    CompletionStage<SWCharacter> get(int id);
}
