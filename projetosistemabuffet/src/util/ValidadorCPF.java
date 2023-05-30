package util;

public class ValidadorCPF {
    public static boolean validarCPF(String cpf) {
        // Remover pontos e traços do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos do CPF são iguais
        boolean todosIguais = true;
        for (int i = 0; i < cpf.length() - 1; i++) {
            if (cpf.charAt(i) != cpf.charAt(i + 1)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigito = resto < 2 ? 0 : 11 - resto;

        // Verificar o primeiro dígito verificador
        if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int segundoDigito = resto < 2 ? 0 : 11 - resto;

        // Verificar o segundo dígito verificador
        if (segundoDigito != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        // CPF válido
        return true;
    }
}
