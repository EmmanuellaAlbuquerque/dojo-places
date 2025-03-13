package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.place.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

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
        PlaceEditDTO placeEditDTO = new PlaceEditDTO(2L, "Leblon", "leblon", "centro", "cajazeiras");
        Errors errors = new BeanPropertyBindingResult(placeEditDTO, "placeEditDTO");

        when(placeRepository.existsByCodeAndIdNot(placeEditDTO.code(), placeEditDTO.id())).thenReturn(true);
        placeEditDTOValidator.validate(placeEditDTO, errors);

        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getErrorCount()).isEqualTo(1);
        assertThat(errors.getAllErrors().get(0).getDefaultMessage()).isEqualTo("O Código já está em uso!");
    }
}
