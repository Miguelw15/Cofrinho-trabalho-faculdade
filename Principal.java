import cofrinho.Cofrinho;
import cofrinho.Dolar;
import cofrinho.Euro;
import cofrinho.Real;
import cofrinho.TipoMoeda;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static final Scanner teclado = new Scanner(System.in);
    private static final Cofrinho cofre = new Cofrinho();



    private static void escolherValor(TipoMoeda tipoMoeda, boolean addOrNot){
        boolean estaEscolhendoValor = true; 
        double valor;

        while (estaEscolhendoValor) {
            try {

                System.out.print("VALOR: ");

                valor = teclado.nextDouble();

                switch (tipoMoeda) {
                    case REAL ->{ 
                        if (addOrNot) {
                            cofre.adicionarMoeda(new Real(valor));
                        }
                        else {
                            cofre.removerMoeda(new Real(valor));
                        }
                    }
                    case EURO -> {
                        if (addOrNot) {
                            cofre.adicionarMoeda(new Euro(valor));
                        }
                        else {
                            cofre.removerMoeda(new Euro(valor));
                        }
                    }
                    case DOLAR -> {
                        if (addOrNot) {
                            cofre.adicionarMoeda(new Dolar(valor));
                        }
                        else {
                            cofre.removerMoeda(new Dolar(valor));
                        }
                    }
                    default -> System.out.println("\nDigite um número válido!\n");
                }

                estaEscolhendoValor = false;
            } 
            catch (InputMismatchException e) {
                System.out.println("\nDigite um número válido!\n");
                teclado.nextLine();
            }
            catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    private static void escolherMoeda(boolean addOrNot) {
        boolean estaEscolhendoMoeda = true;
        int moedaEscolhida;

        while (estaEscolhendoMoeda) {
            try {

                System.out.println("\n======== ESCOLHA UMA MOEDA ========");
                System.out.println("1: Euro");
                System.out.println("2: Real");
                System.out.println("3: Dólar");
                System.out.println("0: Retornar\n");

                moedaEscolhida = teclado.nextInt();

                switch (moedaEscolhida) {
                    case 1 -> escolherValor(TipoMoeda.EURO,addOrNot);
                    case 2 -> escolherValor(TipoMoeda.REAL,addOrNot);
                    case 3 -> escolherValor(TipoMoeda.DOLAR,addOrNot);
                    case 0 -> estaEscolhendoMoeda = false;
                    default -> System.out.println("\nOpção inválida!\n");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("\nDigite um número válido!\n");
                teclado.nextLine();
            }
            catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        boolean active = true;
        int opcaoCofrinho;

        while (active) {
            try {

                System.out.println("\n============== COFRINHO =============");
                System.out.println("1: Adicionar moeda");
                System.out.println("2: Remover moeda");
                System.out.println("3: Listar moedas");
                System.out.println("4: Ver moedas convertidas em Real");
                System.out.println("0: Sair\n");

                opcaoCofrinho = teclado.nextInt();

                switch (opcaoCofrinho) {
                    case 1 -> escolherMoeda(true);
                    case 2 -> escolherMoeda(false);
                    case 3 -> cofre.listarMoedas();
                    case 4 -> cofre.totalEmReal();
                    case 0 -> active = false;
                    default -> System.out.println("Opção inválida!");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("\nDigite um número válido!\n");
                teclado.nextLine();
            }
            catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
