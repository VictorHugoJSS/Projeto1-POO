import java.util.Scanner;

public class Main{
    public static Produto produtos[] = new Produto[10]; // Definindo o tamanho inicial do array da struct
    public static int j = 0; // Definindo a posição no array
    public static Scanner sc = new Scanner(System.in); // Criação de Scanner

    public static Produto[] Array_Resize(){ // metodo para aumentar o tamanho do array
        int newSize = produtos.length * 2; // variavel para o novo tamanho
        Produto[] produto = new Produto[newSize]; // criação do array com o novo tamanho 
        System.arraycopy(produtos, 0, produto, 0, newSize); // Copia dos elementos do arrays antigos para o novo
        return produto;
    }
    public static void Menu_Principal(){ // metodo que tem como função printar o menu
        System.out.println("\tMENU PRINCIPAL\t\n");
        System.out.println("\t1. Adicionar Produto\t");
        System.out.println("\t2. Remover um produto\t");
        System.out.println("\t3. Consultar Produtos\t");
        System.out.println("\t4. Atualizar produto\t\n");
        System.out.println("Digite o Numero da função que você quer acessar ou digite 5 para sair: ");
    }

    public static void print_products(){ // Metodo para printar os produtos
        int k = 1;
        for (int i = 0; i < j; i++){
            System.out.printf("%d.Codigo: %s Nome: %s Valor: %.2f Quant: %d%n", k++, produtos[i].codigo, produtos[i].nome, produtos[i].valor, produtos[i].quant);
        }
    }

    public static Produto[] push(){ // Metodo para adicionar produtos
        int confirm; // Variavel para decidir se adiciona um novo produto

        System.out.println("Digite 1 para adicionar um novo item ou Digite 0 para sair: ");
        confirm = sc.nextInt();

        while (true){
            if (j == produtos.length){ // se j igual o tamanho do array. O array é aumenta de tamanho pelo metodo
                produtos = Array_Resize();
            }
            if (confirm == 0){ // se confirm for igual a 0. O while é parado
                break;
            }
            produtos[j] = new Produto(); // permite a utilização da posição no array

            System.out.println("Codigo: ");
            produtos[j].codigo = sc.next();

            System.out.println("Nome: ");
            produtos[j].nome = sc.next();

            while (produtos[j].valor < 0){
                System.out.println("Preço: ");
                produtos[j].valor = sc.nextDouble();
            }

            while (produtos[j].quant <= 0){
                System.out.println("Quant: ");
                produtos[j].quant = sc.nextInt();
            }
            System.out.println("Digite 1 para adicionar um novo item ou Digite 0 para sair: ");
            confirm = sc.nextInt();
            j++;
        }
        return produtos;
    }

    public static Produto[] pop(int pos){ // Metodo que faz a removação do produto no array
        int i, k; 
        for(i = k = 0; i < j; i++){
            if (i != pos){
                produtos[k++] = produtos[i];
            }
        }

        return produtos;
    }

    public static Produto[] Atualizar_produto(){ // Metodo que faz a atualização dos produtos
        print_products();
        System.out.println("\nDigite o numero do produto que você quer atualizar: ");
        int pos = sc.nextInt()-1; 

        System.out.println("Codigo: ");
        produtos[pos].codigo = sc.next();
        System.out.println("Nome: ");
        produtos[pos].nome = sc.next();

        while (produtos[j].valor < 0) { // se o valor for menor que zero, o programa pergunta novamente o valor
            System.out.println("Preço: ");
            produtos[pos].valor = sc.nextDouble();
        }

        while (produtos[j].quant <= 0) { // se o quant for menor ou menor que zero, o programa pergunta novamente
            System.out.println("Quantidade: ");
            produtos[pos].quant = sc.nextInt();   
        }

        return produtos;
    }
    public static void main (String[] args){
        int function; // Função para decidir qual função utilizar
        int pos; // função para definir a posição do produto 

        while (true){
            Menu_Principal();
            function = sc.nextInt();

            if (function == 5){ // se function for 5 o while para parar o while e consequentemente o programa
                break;
            }
            if (function == 1){ // se function for 1 ativa o metodo push
                produtos = push();
            }
            if (function == 2){ // se function for 2 ativa o metodo pop
                print_products();
                System.out.println("Digite o numero item que você quer remover:");
                pos = sc.nextInt();
                produtos = pop(pos-1);
            }
            if (function == 3){ // se function for 3 ativa o metodo print_product para mostrar somente os produtos
                print_products();
            }
            if (function == 4){ // se function for 4 ativa o metodo de atualização de produto
                produtos = Atualizar_produto();
            }
        }
        sc.close();
    }
}