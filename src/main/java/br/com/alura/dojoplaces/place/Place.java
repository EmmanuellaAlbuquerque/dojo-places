package br.com.alura.dojoplaces.place;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String neighborhood;
    private String city;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Place() {

    }

    public Place(String name, String code, String neighborhood, String city, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Place(PlaceCreateDTO place) {
        this.name = place.name();
        this.code = place.code();
        this.neighborhood = place.neighborhood();
        this.city = place.city();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
