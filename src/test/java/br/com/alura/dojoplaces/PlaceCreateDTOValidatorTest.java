package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.place.PlaceCreateDTO;
import br.com.alura.dojoplaces.place.PlaceCreateDTOValidator;
import br.com.alura.dojoplaces.place.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaceCreateDTOValidatorTest {

    PlaceRepository placeRepository;
    PlaceCreateDTOValidator placeCreateDTOValidator;

    @BeforeEach
    void setUp() {
        this.placeRepository = mock(PlaceRepository.class);
        this.placeCreateDTOValidator = new PlaceCreateDTOValidator(placeRepository);
    }

    @Test
    @DisplayName("Should return an error if there is an place with same code")
    void should_return_an_error_if_there_is_an_place_with_same_code() {
        PlaceCreateDTO placeCreateDTO = new PlaceCreateDTO("Leblon", "leblon", "centro", "cajazeiras");

        Errors errors = new BeanPropertyBindingResult(placeCreateDTO, "placeCreateDTO");

        when(placeRepository.existsByCode(placeCreateDTO.code())).thenReturn(true);
        placeCreateDTOValidator.validate(placeCreateDTO, errors);

        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getErrorCount()).isEqualTo(1);
        assertThat(errors.getAllErrors().get(0).getDefaultMessage()).isEqualTo("O Código já está em uso!");
    }

    @Test
    @DisplayName("Should return no error if the code for the place does not exist")
    void should_return_no_error_if_the_code_for_the_place_does_not_exist() {
        PlaceCreateDTO placeCreateDTO = new PlaceCreateDTO("Leblon", "leblon", "centro", "cajazeiras");

        Errors errors = new BeanPropertyBindingResult(placeCreateDTO, "placeCreateDTO");

        when(placeRepository.existsByCode(placeCreateDTO.code())).thenReturn(false);
        placeCreateDTOValidator.validate(placeCreateDTO, errors);

        assertThat(errors.hasErrors()).isFalse();
        assertThat(errors.getErrorCount()).isEqualTo(0);
        assertThat(errors.getFieldErrors()).isEmpty();
    }
}
