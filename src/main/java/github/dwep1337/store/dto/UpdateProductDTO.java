package github.dwep1337.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateProductDTO(
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    String name,

    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    String description,

    @Positive(message = "Preço deve ser maior que zero")
    @Digits(integer = 10, fraction = 2, message = "Preço deve ter no máximo 10 dígitos inteiros e 2 decimais")
    BigDecimal price) {

    @AssertTrue(message = "Informe ao menos um campo para atualizar")
    public boolean hasAtLeastOneField() {
        return name != null || description != null || price != null;
    }
}
