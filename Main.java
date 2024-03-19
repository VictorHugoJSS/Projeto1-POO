import java.util.Scanner;

public class Main{
    public static Produto[] produtos = new Produto[10];
    public static int j = 0;
    public static Produto[] Array_Resize(){
        int newSize = produtos.length * 2;
        Produto[] produto = new Produto[newSize];
        System.arraycopy(produtos, 0, produto, 0, newSize);
        return produto;
    }
    public static void Menu_Principal(){
        System.out.println("\tMENU PRINCIPAL\t\n");
        System.out.println("\t1. Adicionar Produto\t");
        System.out.println("\t2. Remover um produto\t");
        System.out.println("\t3. Consultar Produtos\t");
        System.out.println("\t4. Atualizar produto\t\n");
        System.out.println("Digite o Numero da função que você quer acessar ou digite 5 para sair: ");
    }

    public static void print_products(){
        int j = 1;
        for (int i = 0; i <= j; i++){
            System.out.printf("%d.Codigo: %s Nome: %s Valor: %.2f Quant: %d%n", j++, produtos[i].codigo, produtos[i].nome, produtos[i].valor, produtos[i].quant);
        }
    }

    public static Produto[] push(){
        Scanner sc = new Scanner(System.in);
        int confirm = 1;

        while (confirm != 0){
            if (j == produtos.length){
                produtos = Array_Resize();
            }
            System.out.print("Codigo: ");
            produtos[j].codigo = sc.nextLine();
            System.out.print("Nome: ");
            produtos[j].nome = sc.nextLine();
            System.out.print("Preço: ");
            produtos[j].valor = sc.nextDouble();
            System.out.print("Quant: ");
            produtos[j].quant = sc.nextInt();

            while (confirm != 1 || confirm != 0){
                System.out.print("Digite 1 para adicionar um novo item ou Digite 0 para sair");
                confirm = sc.nextInt();
            }
            j++;
        }
        sc.close();
        return produtos;
    }

    public static Produto[] pop(int pos){
        for(int i = j = 0; i <= j; i++){
            if (i != pos){
                produtos[j++] = produtos[i];
            }
        }
        return produtos;
    }

    public static Produto[] Atualizar_produto(){
        print_products();
        System.out.println("\nDigite o numero do produto que você quer atualizar: ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt()-1;
        sc.close();

        
        return produtos;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int function, pos;

        Menu_Principal();
        function = sc.nextInt();
        while (function != 5){
            switch (function){
                case 1: produtos = push(); break;
                case 2: print_products(); 
                System.out.print("Digite o número do item que você quer remover: "); 
                pos = sc.nextInt();
                pop(pos-1); break;
                case 3: print_products();
                case 4: 
            }
            Menu_Principal();
            function = sc.nextInt();
        }
        sc.close();
    }
}