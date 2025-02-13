package br.com.alura.dojoplaces.place;

import static br.com.alura.dojoplaces.utils.DateUtils.*;

public record PlaceListDTO (
        Long id,
        String name,
        String code,
        String neighborhood,
        String city,
        String createdAt,
        String updatedAt
) {

    public static PlaceListDTO fromModel(Place place) {
        return new PlaceListDTO(
                place.getId(),
                place.getName(),
                place.getCode(),
                place.getNeighborhood(),
                place.getCity(),
                convertToDayMonthYear(place.getCreatedAt()),
                place.getUpdatedAt() != null ? formattedDaysAgo(place.getUpdatedAt()) : "Não atualizado"
        );
    }
}
