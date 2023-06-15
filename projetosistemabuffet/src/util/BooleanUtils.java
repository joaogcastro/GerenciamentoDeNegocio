package util;

public class BooleanUtils {

    public static boolean formatarSimNao() {
        String resposta;
        do {
            resposta = Console.readString("Digite 'S' para sim ou 'N' para não: ");
        } while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n") && !resposta.equalsIgnoreCase("sim")
                && !resposta.equalsIgnoreCase("não"));

        return resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim");
    }
}