import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;

public class Main{
    public static void Menu_Principal(){
        System.out.println("\tMENU PRINCIPAL\t\n");
        System.out.println("\t1. Adicionar Produto\t");
        System.out.println("\t2. Remover um produto\t");
        System.out.println("\t3. Consultar Produtos\t");
        System.out.println("\t4. Atualizar produto\t\n");
        System.out.println("Digite o Numero da função que você quer acessar ou digite 5 para sair: ");
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String functionString;
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        functionString = JOptionPane.showInputDialog(Menu_Principal(), null);
        function = sc.nextInt();
        while (function != 5){

        }
        sc.close();
    }
}