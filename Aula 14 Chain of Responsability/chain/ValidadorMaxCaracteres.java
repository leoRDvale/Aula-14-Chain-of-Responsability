package chain;

import model.Usuario;

public class ValidadorMaxCaracteres extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (usuario.getSenha().length() > 16) {
            System.out.println("Senha deve ter no máximo 16 caracteres.");
            return false;
        }

        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}