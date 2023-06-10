package util;

public class BooleanUtils {

    public static boolean formatarSimNao() {
        String resposta;
        do {
            resposta = Console.readString("Digite 'S' para sim ou 'N' para não: ");
        } while (!resposta.equalsIgnoreCase("s") || !resposta.equalsIgnoreCase("n") || !resposta.equalsIgnoreCase("sim")
                || !resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));

        if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
            return true;
        } else {
            return false;
        }
    }

}
