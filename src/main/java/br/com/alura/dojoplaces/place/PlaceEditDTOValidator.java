package br.com.alura.dojoplaces.place;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PlaceEditDTOValidator implements Validator {
    private final PlaceRepository placeRepository;

    public PlaceEditDTOValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceEditDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlaceEditDTO placeEditDTO = (PlaceEditDTO) target;

        if (placeRepository.existsByCodeAndIdNot(placeEditDTO.code(), placeEditDTO.id())) {
            errors.rejectValue("code", "", "O Código já está em uso!");
        }
    }
}
