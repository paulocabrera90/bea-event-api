package ar.com.itau.event.application.port.out;

import ar.com.itau.event.domain.SWCharacter;

public interface SWCharacterRepository {
    SWCharacter getById(int id);
}
