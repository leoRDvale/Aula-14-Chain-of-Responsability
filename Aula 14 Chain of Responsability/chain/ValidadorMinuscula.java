package chain;

import model.Usuario;

public class ValidadorMinuscula extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (!usuario.getSenha().matches(".*[a-z].*")) {
            System.out.println("Senha deve possuir letra minúscula.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}