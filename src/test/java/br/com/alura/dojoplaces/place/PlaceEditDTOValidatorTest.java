package br.com.alura.dojoplaces.place;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaceEditDTOValidatorTest {

    PlaceRepository placeRepository;
    PlaceEditDTOValidator placeEditDTOValidator;

    @BeforeEach
    void setUp() {
        this.placeRepository = mock(PlaceRepository.class);
        this.placeEditDTOValidator = new PlaceEditDTOValidator(placeRepository);
    }

    @Test
    @DisplayName("Should return an error if there is an place with same code")
    void should_return_an_error_if_there_is_an_place_with_same_code() {
        PlaceEditDTO placeEditDTO = new PlaceEditDTO(2L, "Leblon", "leblon", "", "centro", "cajazeiras");
        Errors errors = new BeanPropertyBindingResult(placeEditDTO, "placeEditDTO");

        when(placeRepository.existsByCodeAndIdNot(placeEditDTO.code(), placeEditDTO.id())).thenReturn(true);
        placeEditDTOValidator.validate(placeEditDTO, errors);

        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getErrorCount()).isEqualTo(1);
        assertThat(errors.getFieldErrors())
                .extracting(FieldError::getField, FieldError::getRejectedValue)
                .containsExactly(Tuple.tuple("code", "leblon")
        );
        assertThat(errors.getAllErrors().getFirst().getDefaultMessage()).isEqualTo("O Código já está em uso!");
    }

    @Test
    @DisplayName("Should return no error if the code for the place does not exist")
    void should_return_no_error_if_the_code_for_the_place_does_not_exist() {
        PlaceEditDTO placeEditDTO = new PlaceEditDTO(1L, "Leblon", "leblon", "", "centro", "cajazeiras");
        Errors errors = new BeanPropertyBindingResult(placeEditDTO, "placeEditDTO");

        when(placeRepository.existsByCodeAndIdNot(placeEditDTO.code(), placeEditDTO.id())).thenReturn(false);
        placeEditDTOValidator.validate(placeEditDTO, errors);

        assertThat(errors.hasErrors()).isFalse();
        assertThat(errors.getErrorCount()).isEqualTo(0);
        assertThat(errors.getFieldErrors()).isEmpty();
        assertThat(errors.getAllErrors()).isEmpty();
    }
}
