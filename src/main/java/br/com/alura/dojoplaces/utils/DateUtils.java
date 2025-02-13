package br.com.alura.dojoplaces.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static final DateTimeFormatter DD_MM_YYYY_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String convertToDayMonthYear(LocalDateTime datetime) {
        return datetime.format(DD_MM_YYYY_FORMATTER);
    }

    public static long daysFromNow(LocalDateTime datetime) {
        return datetime.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }

    public static String formattedDaysAgo(LocalDateTime datetime){
        long daysAgo = DateUtils.daysFromNow(datetime);
        String formattedDaysAgo = "";

        switch ((int) daysAgo) {
            case 0 -> formattedDaysAgo = "Hoje";
            case 1 -> formattedDaysAgo = "Ontem";
            default -> formattedDaysAgo = daysAgo + " dias atrás";
        }

        return formattedDaysAgo;
    }
}
