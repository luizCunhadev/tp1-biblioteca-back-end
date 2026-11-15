
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Regras de negocio da biblioteca
        final int PRAZO_EMPRESTIMO = 14;
        final int LIMITE_EMPRESTIMOS = 3;
        final double VALOR_MULTA_DIA = 1.00;

        // Identificacao do membro
        String tipoMembro = "";

        System.out.println("======================================");
        System.out.println(" SISTEMA DE GESTAO DE BIBLIOTECA");
        System.out.println("======================================");

        System.out.println("\nSelecione o tipo de membro:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Funcionario");
        System.out.print("Opcao: ");

        int opcaoTipo = entrada.nextInt();

        switch (opcaoTipo) {
            case 1:
                tipoMembro = "Aluno";
                break;
            case 2:
                tipoMembro = "Professor";
                break;
            case 3:
                tipoMembro = "Funcionario";
                break;
            default:
                tipoMembro = "Nao identificado";
                break;
        }

        // Quantidade de emprestimos ativos
        System.out.print("\nInforme a quantidade de emprestimos ativos: ");
        int emprestimosAtivos = entrada.nextInt();

        if (emprestimosAtivos < 0 || emprestimosAtivos > LIMITE_EMPRESTIMOS) {
            System.out.println("Quantidade invalida de emprestimos.");
            entrada.close();
            return;
        }

        int opcao;

        // Menu principal
        do {

            System.out.println("\n======================================");
            System.out.println(" MENU PRINCIPAL");
            System.out.println("======================================");
            System.out.println("Membro: " + tipoMembro);
            System.out.println("Emprestimos ativos: " + emprestimosAtivos);

            System.out.println("\n1 - Solicitar emprestimo");
            System.out.println("2 - Calcular multa por atraso");
            System.out.println("3 - Consultar regras da biblioteca");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opcao: ");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:

                    // Verifica o limite de emprestimos
                    if (emprestimosAtivos >= LIMITE_EMPRESTIMOS) {

                        System.out.println("\nEmprestimo nao autorizado!");
                        System.out.println("O membro ja possui 3 emprestimos ativos.");

                    } else {

                        emprestimosAtivos++;

                        System.out.println("\nEmprestimo realizado com sucesso!");
                        System.out.println("Tipo de membro: " + tipoMembro);
                        System.out.println("Prazo para devolucao: "
                                + PRAZO_EMPRESTIMO + " dias");

                        System.out.println("Emprestimos ativos: "
                                + emprestimosAtivos);
                    }

                    break;

                case 2:

                    // Calculo da multa por dias de atraso
                    System.out.print("\nInforme os dias de atraso: ");
                    int diasAtraso = entrada.nextInt();

                    if (diasAtraso < 0) {

                        System.out.println("Quantidade de dias invalida.");

                    } else if (diasAtraso == 0) {

                        System.out.println("Devolucao dentro do prazo.");
                        System.out.println("Nenhuma multa foi aplicada.");

                    } else {

                        double valorMulta = diasAtraso * VALOR_MULTA_DIA;

                        System.out.printf(
                                "Multa total: R$ %.2f%n", valorMulta
                        );

                    }

                    break;

                case 3:

                    // Exibicao das regras de negocio
                    System.out.println("\n===== REGRAS DA BIBLIOTECA =====");
                    System.out.println("Prazo de emprestimo: "
                            + PRAZO_EMPRESTIMO + " dias");

                    System.out.println("Limite de emprestimos ativos: "
                            + LIMITE_EMPRESTIMOS);

                    System.out.printf("Multa por dia: R$ %.2f%n",
                            VALOR_MULTA_DIA);

                    break;

                case 0:

                    System.out.println("\nSistema encerrado.");
                    System.out.println("Obrigado por utilizar a biblioteca!");

                    break;

                default:

                    System.out.println("\nOpcao invalida. Tente novamente.");

                    break;
            }

        } while (opcao != 0);

        entrada.close();
    }
}
