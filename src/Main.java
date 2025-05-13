import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            System.out.println("**************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            op = scanner.nextInt();

            System.out.println("**************************");

            if (op >= 1 && op <= 6) {
                try {
                    ConsultaCambio.conversaoCambio(op, scanner);
                } catch (IOException | InterruptedException e) {
                    System.out.println("Erro na conversão: " + e.getMessage());
                }
            } else if (op == 7) {
                System.out.println("Saindo do sistema... Até logo!");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (op != 7);

        scanner.close();
    }
}