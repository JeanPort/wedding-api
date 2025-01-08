package br.com.jean.wedding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PresenteDTO(
        Integer id,
        @NotBlank(message = "O nome não pode ser vazio") String nome,
        String descricao,
        String linkFoto,
        @NotNull(message = "Não pode ser nulo") @Positive(message = "O preço deve ser positivo") Double preco) {
}
