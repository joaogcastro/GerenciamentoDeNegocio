package util;

public class CNPJUtils {
    
    public static String formatarCNPJ(String cnpj) {
        // Remove os caracteres especiais do CNPJ
        String cnpjSemCaracteresEspeciais = cnpj.replaceAll("[\\.-/]", "");
        return cnpjSemCaracteresEspeciais;
    }
    
    public static boolean validarCNPJ(String cnpj) {
        // Remover pontos, traços e barras do CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
    
        // Verificar se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }
    
        // Verificar se todos os dígitos do CNPJ são iguais
        boolean todosIguais = true;
        for (int i = 0; i < cnpj.length() - 1; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(i + 1)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }
    
        // Calcular o primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso > 9) {
                peso = 2;
            }
        }
        int resto = soma % 11;
        int primeiroDigito = resto < 2 ? 0 : 11 - resto;
    
        // Verificar o primeiro dígito verificador
        if (primeiroDigito != Character.getNumericValue(cnpj.charAt(12))) {
            return false;
        }
    
        // Calcular o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso > 9) {
                peso = 2;
            }
        }
        resto = soma % 11;
        int segundoDigito = resto < 2 ? 0 : 11 - resto;
    
        // Verificar o segundo dígito verificador
        if (segundoDigito != Character.getNumericValue(cnpj.charAt(13))) {
            return false;
        }
    
        // CNPJ válido
        return true;
    }
    
}


