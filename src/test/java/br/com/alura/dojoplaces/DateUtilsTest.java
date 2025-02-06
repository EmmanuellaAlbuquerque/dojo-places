package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.utils.DateUtils;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class DateUtilsTest {

    @Test
    @DisplayName("Deve retornar a data no formato dd/MM/yyyy")
    void shouldReturnFormattedDate() {
        LocalDateTime actualDate = LocalDateTime.of(2025, Month.FEBRUARY, 6, 0, 0);
        String formattedDate = DateUtils.convertToDayMonthYear(actualDate);
//        Assertions.assertEquals("06/02/2025", formattedDate);
        Assertions.assertThat(formattedDate).isEqualTo(formattedDate);
    }

    @Test
    @DisplayName("Deve retornar a quantidade de dias atrás dada uma data")
    void shouldReturnFormattedDateOfDaysAgo() {
        LocalDateTime twoDaysAgo = LocalDateTime.now().minusDays(2L);
        LocalDateTime elevenDaysAgo = LocalDateTime.now().minusDays(11L);

        long formatted2DaysAgo = DateUtils.daysFromNow(twoDaysAgo);
        long formatted11DaysAgo = DateUtils.daysFromNow(elevenDaysAgo);

//        Assertions.assertEquals(2, formattedDaysAgo);
        Assertions.assertThat(formatted2DaysAgo).isEqualTo(2L);
        Assertions.assertThat(formatted11DaysAgo).isEqualTo(11L);
    }
}
