public class CombinationsV2 {

    public static void combinations(int n, int k) {
        int [] combination = new int [k];
        combinationsHelper(n, k, 0, combination);
    }

    public static void print(int [] combination) {
        for (int i = 0; i< combination.length; i++) {
            System.out.print(combination[i]);
        }
        System.out.println();
    }

    public static void combinationsHelper(int n, int k, int i, int [] combination) {
        if (k == 0) {
            print(combination);
            return;
        }

        for (int a = i + 1; a <= n - k + 1; a++) {
                if (i == 0) {
                    combination[i] = a - 1;
                    combinationsHelper(n, k - 1, i + 1, combination);
                } else {
                    if (a - 1 != combination[i-1]) {
                        combination[i] = a - 1;
                        combinationsHelper(n, k - 1, i + 1, combination);
                    }
                }

        }
    }

    public static void main(String [] args) {
        int n= 4;
        int k =3;

        combinations(n, k);
    }
}
