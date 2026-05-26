package chain;

import model.Usuario;

public class ValidadorMinCaracteres extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (usuario.getSenha().length() < 8) {
            System.out.println("Senha deve ter pelo menos 8 caracteres.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}