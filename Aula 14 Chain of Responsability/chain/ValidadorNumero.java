package chain;

import model.Usuario;

public class ValidadorNumero extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (!usuario.getSenha().matches(".*\\d.*")) {
            System.out.println("Senha deve possuir número.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}