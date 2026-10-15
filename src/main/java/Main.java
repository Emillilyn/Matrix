import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.println("Input size of the matrix N (2-10): ");
            n = input.nextInt();
        } while (n < 2 || n > 10);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = (int) (Math.random() * 9 ) + 1;
        int sum = 0, main = 0, secondary = 0;
        int min = matrix[0][0], max = matrix[0][0];
        int max_line = 0, max_sum = -1;

        System.out.println("Matrix: ");
        for (int i = 0; i < n; i++) {
            int sum_line = 0;
            for (int j = 0; j < n; j++) {
                int p = matrix[i][j];
                System.out.printf(p + " ");
                sum += p;
                sum_line += p;
                if (p < min) min = p;
                if (p > max) max = p;
                if (i == j) main += p;
                if (i + j == n - 1) secondary += p;
            }
            System.out.println();
            if (sum_line > max_sum) {
                max_sum = sum_line;
                max_line = i + 1;
            }
        }
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Main diagonal: " + main);
        System.out.println("Secondary diagonal: " + secondary);
        System.out.println("Line with biggest sum: " + max_line);
    }
}
