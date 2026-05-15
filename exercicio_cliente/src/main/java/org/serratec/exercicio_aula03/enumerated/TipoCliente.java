package org.serratec.exercicio_aula03.enumerated;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.exercicio_aula03.exception.EnumValidationException;

public enum TipoCliente {
    PF,
    PJ;

    @JsonCreator
    public static TipoCliente verifica(String value) throws EnumValidationException{
        for (TipoCliente tc : values()) {
            if (value.equals(tc.name())) {
                return tc;
            }
        }
        throw new EnumValidationException("Tipo do cliente inválido. Tipos válidos: PF, PJ");
    }
}
