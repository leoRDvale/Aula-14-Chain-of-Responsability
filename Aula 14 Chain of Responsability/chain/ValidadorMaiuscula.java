package chain;

import model.Usuario;

public class ValidadorMaiuscula extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (!usuario.getSenha().matches(".*[A-Z].*")) {
            System.out.println("Senha deve possuir letra maiúscula.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}