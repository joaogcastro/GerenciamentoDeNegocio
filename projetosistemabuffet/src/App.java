import controllers.Login;
import data.IniciarODB;
import util.Console;

public class App {
    public static void main(String[] args) throws Exception {
        boolean executando = true;
        while (executando) {
            if (IniciarODB.adicionarCredenciais() == true) {
                System.out.println(
                        "\nPrograma instalado com sucesso em sua máquina, o banco de dados foi inicializado corretamente.\n");
            }
            Login.fazerLogin();
            String resposta = Console.readString("\nDeseja sair do programa? (S/N): ").toUpperCase();
            if (resposta.equals("S")) {
                executando = false;
            }
        }
    }
}