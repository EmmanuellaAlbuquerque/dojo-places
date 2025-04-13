package br.com.alura.dojoplaces.place;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PlaceCreateDTOValidator implements Validator {
    private final PlaceRepository placeRepository;

    public PlaceCreateDTOValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlaceCreateDTO placeCreateDTO = (PlaceCreateDTO) target;

        if (placeRepository.existsByCode(placeCreateDTO.code())) {
            errors.rejectValue("code", "", "O Código já está em uso!");
        }
    }
}
