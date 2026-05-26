import chain.*;
import model.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o login: ");
        String login = sc.nextLine();

        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();

        Usuario usuario = new Usuario(login, senha);

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


        boolean resultado = loginVal.validar(usuario);

        if (resultado) {
            System.out.println("\nLogin e senha válidos!");
        } else {
            System.out.println("\nFalha na validação.");
        }

        sc.close();
    }
}