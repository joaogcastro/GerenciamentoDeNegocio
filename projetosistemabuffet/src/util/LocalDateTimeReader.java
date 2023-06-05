package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LocalDateTimeReader {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static LocalDateTime readLocalDateTime(String prompt) {
        try (Scanner scanner = new Scanner(System.in)) {
            LocalDateTime dateTime = null;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print(prompt);
                    String input = scanner.nextLine();
                    dateTime = LocalDateTime.parse(input, formatter);
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Formato inválido. Digite novamente.");
                }
            }

            return dateTime;
        }
    }
}
