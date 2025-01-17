package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PlaceCreateDTO(

        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9]*$")
        String code,

        @NotBlank
        @Size(max = 100)
        String neighborhood,

        @NotBlank
        @Size(max = 100)
        String city
) {
}
