package chain;

import model.Usuario;

public class ValidadorEspecial extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (!usuario.getSenha().matches(".*[@#$%&*].*")) {
            System.out.println("Senha deve possuir caractere especial.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}