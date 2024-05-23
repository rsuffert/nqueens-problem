import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite a quantidade de rainhas desejada: ");
        int queens = Integer.parseInt(in.nextLine());
        NQueens nq = new NQueens(queens);
        System.out.println("Solutions: ");
        nq.printSolutions();
        in.close();
    }
}
