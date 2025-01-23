package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PlaceCreateDTO(

        @NotBlank(message = "O Nome é obrigatório")
        @Size(max = 100)
        String name,

        @NotBlank(message = "O Código é obrigatório")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "O Código não pode ter caracteres especiais e nem espaço")
        String code,

        @NotBlank(message = "O Bairro é obrigatório")
        @Size(max = 100)
        String neighborhood,

        @NotBlank(message = "A Cidade é obrigatória")
        @Size(max = 100)
        String city
) {
}
