package br.com.alura.dojoplaces.place;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PlaceEditDTO(
        @NotNull
        Long id,

        @NotBlank(message = "O Nome é obrigatório")
        @Size(max = 100)
        String name,

        @NotBlank(message = "O Código é obrigatório")
        @Pattern(regexp = "^[a-zA-Z0-9-]*$", message = "O Código não pode ter caracteres especiais e nem espaço")
        String code,

        @Nullable
        String cep,

        @NotBlank(message = "O Bairro é obrigatório")
        @Size(max = 100)
        String neighborhood,

        @NotBlank(message = "A Cidade é obrigatória")
        @Size(max = 100)
        String city
) {

    public static PlaceEditDTO fromModel(Place place) {
        return new PlaceEditDTO(
                place.getId(),
                place.getName(),
                place.getCode(),
                place.getCode(),
                place.getNeighborhood(),
                place.getCity()
        );
    }
}
