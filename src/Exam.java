import java.util.HashSet;
import java.util.Scanner;

public class Exam {

    public static void arrange(int n) {
        int m =  (int)Math.ceil(n * 1./2);
        int diff = n - m;

        if (n%2 == 0) {
            if (n == 2) {
                System.out.println(1);
                System.out.println(1);

            } else if (n == 4) {
                System.out.println(4);
                System.out.print("3 1 4 2");

            } else {

                System.out.println(n);
                for (int i = 1; i <= m; i++) {
                    System.out.print(i + " " + (i + diff) + " ");
                }
            }
        } else {


            if (n == 3) {
                System.out.println(2);

                System.out.println("1 3");
            } else {
                System.out.println(n);

                System.out.print(n + " ");
                for (int i = m; i < n; i++) {
                    System.out.print(i + " " + (i - diff) + " ");
                }


            }
        }

    }

    public static void main(String [] args) throws Exception {

        Scanner read = new Scanner(System.in);
        int n = read.nextInt();

        arrange(n);

    }
}
