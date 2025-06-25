import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao CineJava!");
        System.out.println("Escolha o filme:");
        System.out.println("1 - Matrix");
        System.out.println("2 - Dona");
        System.out.println("3 - Bolinho de Chuva");
        System.out.print("Digite o número do filme: ");
        int opcaoFilme = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        String nomeFilme = "";
        switch (opcaoFilme) {
            case 1: nomeFilme = "Matrix"; break;
            case 2: nomeFilme = "Dona"; break;
            case 3: nomeFilme = "Bolinho de Chuva"; break;
            default: 
                System.out.println("Opção inválida!");
                scanner.close();
                return;
        }

        System.out.print("O filme é dublado? (s/n): ");
        String respostaDublado = scanner.nextLine().trim().toLowerCase();
        boolean dublado = respostaDublado.equals("s");

        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1 - Comum");
        System.out.println("2 - Meia Entrada");
        System.out.println("3 - Família");
        System.out.print("Digite o número do tipo de ingresso: ");
        int tipoIngresso = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        double valorBase = 30.0; // valor fixo para todos os ingressos neste exemplo
        Ingresso ingresso = null;

        if (tipoIngresso == 1) {
            ingresso = new Ingresso(valorBase, nomeFilme, dublado);
        } else if (tipoIngresso == 2) {
            ingresso = new MeiaEntrada(valorBase, nomeFilme, dublado);
        } else if (tipoIngresso == 3) {
            System.out.print("Quantas pessoas? ");
            int pessoas = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            ingresso = new IngressoFamilia(valorBase, nomeFilme, dublado, pessoas);
        } else {
            System.out.println("Tipo de ingresso inválido!");
            scanner.close();
            return;
        }

        System.out.println("\n===== SEU TICKET =====");
        System.out.println("Filme: " + ingresso.getDescricao());
        System.out.println("Tipo de ingresso: " +
            (tipoIngresso == 1 ? "Comum" :
             tipoIngresso == 2 ? "Meia Entrada" : "Família"));
        System.out.printf("Valor a pagar: R$ %.2f\n", ingresso.getValorReal());
        System.out.println("======================");

        scanner.close();
    }
}