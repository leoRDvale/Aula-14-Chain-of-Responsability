import chain.*;
import model.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Validador loginVal = new ValidadorLogin();
        Validador maiuscula = new ValidadorMaiuscula();
        Validador minuscula = new ValidadorMinuscula();
        Validador especial = new ValidadorEspecial();
        Validador numero = new ValidadorNumero();
        Validador tresNumeros = new ValidadorTresNumeros();
        Validador min = new ValidadorMinCaracteres();
        Validador max = new ValidadorMaxCaracteres();

        loginVal.setProximo(maiuscula);
        maiuscula.setProximo(minuscula);
        minuscula.setProximo(especial);
        especial.setProximo(numero);
        numero.setProximo(tresNumeros);
        tresNumeros.setProximo(min);
        min.setProximo(max);

        boolean valido = false;

        while (!valido) {

            System.out.println("\n===== SISTEMA DE LOGIN =====");
            System.out.println("\n===== A Senha deve ter letra Maiúscula, minúscula, número, caractere especial =====");
            System.out.println("\n===== No mínimo 8 digitos, e no máximo 16 =====");
            
            //login para testes: leonard
            
            System.out.print("Digite o login: ");
            String login = sc.nextLine();

            System.out.print("Digite a senha: ");
            String senha = sc.nextLine();

            Usuario usuario = new Usuario(login, senha);

            
            valido = loginVal.validar(usuario);

            if (!valido) {
                System.out.println("\nSenha ou login inválidos.");
                System.out.println("Tente novamente.\n");
            } else {
                System.out.println("\nLogin realizado com sucesso!");
            }
        }

        sc.close();
    }
}
