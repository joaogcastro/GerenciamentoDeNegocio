import controllers.Login;
import data.IniciarODB;
import data.LoginData;
import models.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
            
        //IniciarODB.adicionarCredenciais();
        Login.fazerLogin();
    }
}
