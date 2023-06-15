package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LocalDateTimeReader {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static LocalDateTime readLocalDateTimeFromInput(Scanner scanner) {
        String input = scanner.nextLine();
        return LocalDateTime.parse(input, FORMATTER);
    }

}