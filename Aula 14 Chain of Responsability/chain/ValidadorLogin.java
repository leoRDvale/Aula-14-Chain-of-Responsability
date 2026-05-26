package chain;

import model.Usuario;

public class ValidadorLogin extends Validador {

    private final String[] logins = {
            "leonard",
            "admin",
            "usuario123"
    };

    @Override
    public boolean validar(Usuario usuario) {

        boolean encontrado = false;

        for (String login : logins) {
            if (login.equals(usuario.getLogin())) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Login não cadastrado.");
            return false;
        }

        System.out.println("Login válido.");

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}