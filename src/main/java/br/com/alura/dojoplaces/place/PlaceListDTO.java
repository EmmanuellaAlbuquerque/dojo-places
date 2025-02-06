package br.com.alura.dojoplaces.place;

public record PlaceListDTO (
        Long id,
        String name,
        String code,
        String neighborhood,
        String city,
        String createdAt,
        String updatedAt
) {
}
