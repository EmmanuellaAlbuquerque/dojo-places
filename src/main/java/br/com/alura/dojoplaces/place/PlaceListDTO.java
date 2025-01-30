package br.com.alura.dojoplaces.place;

public record PlaceListDTO (
        String name,
        String code,
        String neighborhood,
        String city,
        String createdAt,
        String updatedAt
) {
}
