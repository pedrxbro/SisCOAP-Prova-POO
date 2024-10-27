package br.univali.cc.poo.provam2.visao;
import br.univali.cc.poo.provam2.dominio.Aquisicao;
import br.univali.cc.poo.provam2.dominio.MaoObra;
import br.univali.cc.poo.provam2.dominio.Projeto;
import java.util.Scanner;

public class Interface {
    
    Projeto projeto;
    
    private String lerValor(String rotulo) {
        System.out.print(rotulo+": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }
    public void menu() {
        char opcao;
        do {
            System.out.println("1 - Insira os dados do projeto");
            System.out.println("2 - Inserir despesas");
            System.out.println("3 - Ver custo do projeto");
            System.out.println("4 - Ver valor a ser cobrado");
            System.out.println("s - sair");
            opcao = lerValor("Digite uma opçao do menu").charAt(0);
            switch (opcao) {
                case '1': criarProjeto(); break;
                case '2': criarDespesa(); break;
                case '3': verCusto(); break;
                case '4': verValorCobrado(); break;
                case 's': System.out.println("FIM"); break;
            }
        } while (opcao != 's');
    }
    private void criarProjeto(){
        String nome = lerValor("Digite o nome do projeto");
        String dataInicio = lerValor("Digite a data de início");
        String dataFim = lerValor("Digite a data de fim");
        double margemLucro = Double.parseDouble(lerValor("Digite a margem de lucro"));
        this.projeto = new Projeto(nome, dataInicio, dataFim, margemLucro);
    }

    private void criarDespesa() {
        if (projeto == null) {  // Verifica se o projeto foi criado
            System.out.println("Por favor, crie o projeto antes de adicionar despesas.");
            return;
        }

        char opcao;
        System.out.println("Qual despesa gostaria de incluir? A ou M");
        opcao = lerValor("Digite uma opção do menu").charAt(0);

        do {
            if (opcao == 'M') {
                String descricao = lerValor("Digite a descrição");
                int quantidadeHoras = Integer.parseInt(lerValor("Digite a quantidade de horas"));
                char dificuldade = lerValor("Digite a dificuldade (F, M, D)").charAt(0);

                // Adiciona a despesa de mão de obra ao projeto
                projeto.adicionarDespesa(descricao, quantidadeHoras, dificuldade);

                opcao = lerValor("Deseja adicionar outra despesa? S ou N").charAt(0);
                if (opcao == 'S') {
                    criarDespesa();
                } else {
                    menu();
                }

            } else if (opcao == 'A') {
                String descricao = lerValor("Digite a descrição");
                double valorUnitario = Double.parseDouble(lerValor("Digite o valor unitário"));
                int quantidadeItens = Integer.parseInt(lerValor("Digite a quantidade de itens"));

                // Adiciona a despesa de aquisição ao projeto
                projeto.adicionarDespesa(descricao, valorUnitario, quantidadeItens);

                opcao = lerValor("Deseja adicionar outra despesa? S ou N").charAt(0);
                if (opcao == 'S') {
                    criarDespesa();
                } else {
                    menu();
                }
            }
        } while (opcao != 'N');
    }

    private void verCusto(){
        if (projeto != null) {
            double precoCusto = projeto.calcularCusto();
            System.out.println("O custo do serviço é R$" + precoCusto);
        } else {
            System.out.println("O projeto ainda não foi criado.");
        }
    }
    
    private void verValorCobrado(){
        if(projeto != null) {
            double precoFinal = projeto.calcularPrecoFinal();
            System.out.println("O preço final é R$"+precoFinal);
        } else {
            System.out.println("O projeto ainda não foi criado.");
        }
    }
}
