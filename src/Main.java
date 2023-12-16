import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exercicio01();
        Exercicio02();
        Exercicio03();



    }

    public static void Exercicio01() {
        double valorEmprestimo, taxaJuros, devendo, devendoTotal, amortizacaoTotal,jurosTotal, amortizacao;
        int totalMeses;

        //Entrada do usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qual o valor de um empréstimo: ");
        valorEmprestimo = scanner.nextDouble();
        System.out.print("Qual o tempo para pagamento: ");
        totalMeses = scanner.nextInt();
        System.out.print("Qual a taxa de juros do empréstimo: ");
        taxaJuros = scanner.nextDouble();

        devendo = valorEmprestimo;
        devendoTotal = devendo;
        amortizacaoTotal = 0;
        jurosTotal = 0;
        amortizacao = (devendoTotal/totalMeses);

        System.out.printf("Valor fixo da amortização: R$ %.2f, Saldo devedor total: R$ %.2f com uma taxa de juros de %.1f%% ao mês%n",
                amortizacao*10, devendoTotal, taxaJuros);

        for (int mes = 1; mes <= totalMeses; mes++) {
            double jurosMensal = (devendo * (taxaJuros / 100));
            double prestacaoMensal = (jurosMensal + amortizacao);
            devendo -= amortizacao;

            devendoTotal -= amortizacao;
            amortizacaoTotal += amortizacao;
            jurosTotal += jurosMensal;

            System.out.printf("Parcela %d | Juros: R$ %.2f | Prestação: R$ %.2f | Saldo devedor: R$ %.2f%n",
                    mes, jurosMensal*10, prestacaoMensal*10, devendo*10);
        }


        System.out.printf("Total: Prestação R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f%n",
                (amortizacaoTotal + jurosTotal)*10, jurosTotal*10, amortizacaoTotal);
    }

    public static void Exercicio02(){
        double temperatura = 0, temperaturaConvertida;
        char unidadeOrigem = 0, unidadeDestino = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe a temperatura:");
            temperatura = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Digite um valor numerico da temperatura");
        }

        try {
            System.out.println("Qual a unidade de origem dessa temperatura? [C, K, F]");
            unidadeOrigem = scanner.next().charAt(0);
        } catch (Exception e) {
            System.out.println("Digite um carácter");
        }


        try {
            System.out.println("Qual a unidade de destino dessa temperatura? [C, K, F]");
            unidadeDestino = scanner.next().charAt(0);
        } catch (Exception e) {
            System.out.println("Digite um carácter");
        }


        switch (unidadeOrigem) {
            case 'C':
                switch (unidadeDestino) {
                    case 'C':
                        temperaturaConvertida = temperatura;
                        break;
                    case 'K':
                        temperaturaConvertida = temperatura + 273.15;
                        break;
                    case 'F':
                        temperaturaConvertida = (temperatura * 9 / 5) + 32;
                        break;
                    default:
                        System.out.println("Unidade inválida.");
                        return;
                }
                break;

            case 'K':
                switch (unidadeDestino) {
                    case 'C':
                        temperaturaConvertida = temperatura - 273.15;
                        break;
                    case 'K':
                        temperaturaConvertida = temperatura;
                        break;
                    case 'F':
                        temperaturaConvertida = ((temperatura - 273.15) * 9 / 5) + 32;
                        break;
                    default:
                        System.out.println("Unidade inválida.");
                        return;
                }
                break;

            case 'F':
                switch (unidadeDestino) {
                    case 'C':
                        temperaturaConvertida = (temperatura - 32) * 5 / 9;
                        break;
                    case 'K':
                        temperaturaConvertida = (temperatura - 32) * 5 / 9 + 273.15;
                        break;
                    case 'F':
                        temperaturaConvertida = temperatura;
                        break;
                    default:
                        System.out.println("Unidade inválida.");
                        return;
                }
                break;

            default:
                System.out.println("Unidade inválida.");
                return;
        }

        System.out.printf("%.2f %c = %.2f %c%n", temperatura, unidadeOrigem, temperaturaConvertida, unidadeDestino);
    }

    public static void Exercicio03(){
        int numero;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número inteiro para desenhar o triângulo:");
        numero = scanner.nextInt();

        numero = numero/2;

        if (numero%2 == 0){
            numero++;
        }

        for (int i = numero - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * (numero - i) - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();

        for (int i = numero - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * (numero - i) - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * (numero - i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}