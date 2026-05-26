package chain;

import model.Usuario;

public class ValidadorTresNumeros extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        if (usuario.getSenha().matches(".*\\d{3}.*")) {
            System.out.println("Senha não pode possuir 3 números consecutivos.");
            return false;
        }
        
        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}