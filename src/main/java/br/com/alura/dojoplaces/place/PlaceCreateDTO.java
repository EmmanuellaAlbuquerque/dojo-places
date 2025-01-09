package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PlaceCreateDTO(

        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        String code, // nao pode ter caracteres especiais e nem espaço

        @NotBlank
        @Size(max = 100)
        String neighborhood,

        @NotBlank
        @Size(max = 100)
        String city

//        @NotNull
//        @PastOrPresent
//        LocalDateTime createdAt,
//
//        LocalDateTime updatedAt
) {
}
