package chain;

import model.Usuario;

public class ValidadorTresNumeros extends Validador {

    @Override
    public boolean validar(Usuario usuario) {

        String senha = usuario.getSenha();

        for (int i = 0; i < senha.length() - 2; i++) {

            char c1 = senha.charAt(i);
            char c2 = senha.charAt(i + 1);
            char c3 = senha.charAt(i + 2);

            if (Character.isDigit(c1) &&
                    Character.isDigit(c2) &&
                    Character.isDigit(c3)) {

                int n1 = Character.getNumericValue(c1);
                int n2 = Character.getNumericValue(c2);
                int n3 = Character.getNumericValue(c3);

                if ((n2 == n1 + 1) && (n3 == n2 + 1)) {

                    System.out.println("Senha não pode possuir 3 números sequenciais.");
                    return false;
                }
            }
        }


        if (proximo != null) {
            return proximo.validar(usuario);
        }

        return true;
    }
}