import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite a quantidade de rainhas desejada: ");
        int queens = Integer.parseInt(in.nextLine());
        System.out.print("Deseja encontrar apenas uma solução? [S/N]: ");
        boolean oneSolution = in.nextLine().trim().toUpperCase().charAt(0) == 'S';
        NQueens nq = new NQueens(queens);
        System.out.println("Solutions: ");
        nq.printSolutions(oneSolution);
        in.close();
    }
}
