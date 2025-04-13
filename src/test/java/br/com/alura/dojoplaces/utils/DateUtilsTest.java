package br.com.alura.dojoplaces.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class DateUtilsTest {

    @Test
    @DisplayName("Deve retornar a data formatada como hoje")
    void shouldReturnFormattedDateAtAsToday() {
        String formattedDate = DateUtils.formattedDaysAgo(LocalDateTime.now());
        Assertions.assertThat(formattedDate).isEqualTo("Hoje");
    }

    @Test
    @DisplayName("Deve retornar a data formatada como ontem")
    void shouldReturnFormattedDateAtAsYesterday() {
        String formattedDate = DateUtils.formattedDaysAgo(LocalDateTime.now().minusDays(1));
        Assertions.assertThat(formattedDate).isEqualTo("Ontem");
    }

    @Test
    @DisplayName("Deve retornar a data formatada como X dias atrás")
    void shouldReturnFormattedDateAtTodayAsDayAgo() {
        String formattedDate = DateUtils.formattedDaysAgo(LocalDateTime.now().minusDays(2));
        Assertions.assertThat(formattedDate).isEqualTo("2 dias atrás");
    }

    @Test
    @DisplayName("Deve retornar a data no formato dd/MM/yyyy")
    void shouldReturnFormattedDate() {
        LocalDateTime actualDate = LocalDateTime.of(2025, Month.FEBRUARY, 6, 0, 0);
        String formattedDate = DateUtils.convertToDayMonthYear(actualDate);
        Assertions.assertThat(formattedDate).isEqualTo("06/02/2025");
    }

    @Test
    @DisplayName("Deve retornar a quantidade de dias atrás dada uma data")
    void shouldReturnFormattedDateOfDaysAgo() {
        LocalDateTime twoDaysAgo = LocalDateTime.now().minusDays(2L);
        LocalDateTime elevenDaysAgo = LocalDateTime.now().minusDays(11L);

        long formatted2DaysAgo = DateUtils.daysFromNow(twoDaysAgo);
        long formatted11DaysAgo = DateUtils.daysFromNow(elevenDaysAgo);

        Assertions.assertThat(formatted2DaysAgo).isEqualTo(2L);
        Assertions.assertThat(formatted11DaysAgo).isEqualTo(11L);
    }
}
