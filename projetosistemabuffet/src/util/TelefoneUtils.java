package util;

public class TelefoneUtils {

    public static String formatarTelefone(String telefone) {
        // Remove todos os caracteres que não sejam dígitos
        String digitsOnly = telefone.replaceAll("[^0-9]", "");

        // Verifica se o número de dígitos é válido
        if (digitsOnly.length() != 11) {
            return telefone; // retorna o número original se não for válido
        }

        // Formata o telefone no formato "(XX)XXXXX-XXXX"
        String formattedTelefone = "(" + digitsOnly.substring(0, 2) + ")"
                + digitsOnly.substring(2, 7) + "-" + digitsOnly.substring(7);

        return formattedTelefone;
    }
}