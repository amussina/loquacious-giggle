public class CombinationsV3 {


    public static void combinations(String s, int k) {

        int n = s.length();

        k = Math.min(n, k);

        char [] comb = new char[k];
        combinationsHelper2(s, n, k, 0, comb, -1);

    }

    public static void print(char [] combination) {
        for (int i = 0; i< combination.length; i++) {
            System.out.print(combination[i]);
        }
        System.out.println();
    }

    public static void combinationsHelper(String s, int n, int k, int i, char [] combination) {
        if (k == 0) {
            print(combination);
            return;
        }

        for (int a = i + 1; a <= n - k + 1; a++) {
            if (i == 0) {
                combination[i] = s.charAt(a-1);
                combinationsHelper(s, n, k - 1, i + 1, combination);
            } else {
                if (s.charAt(a-1) != combination[i-1]) {
                    combination[i] = s.charAt(a-1);
                    combinationsHelper(s, n, k - 1, i + 1, combination);
                }
            }

        }
    }


    public static void combinationsHelper2(String s, int n, int k, int i, char [] combination, int prev) {
        if (k == 0) {
            print(combination);
            return;
        }

        for (int a = prev + 1; a < n - k + 1; a++) {

                combination[i] = s.charAt(a);
                combinationsHelper2(s, n, k - 1, i + 1, combination, a);

        }
    }

    public static void main(String [] args) {

        int k=3;

        String str = "0123";

        combinations(str, k);
    }
}
