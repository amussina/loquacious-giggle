import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Combinations {

    public static void combinations(int n, int k) {
        if (k > n) {
            return;
        }

        boolean [] used = new boolean[n+1];

        Integer [] combination = new Integer[k];

        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        combinationsHelper(n, k, 0, combination, used, res);
        print(res);

    }

    private static void combinationsHelper(int n, int k, int i, Integer [] combination, boolean[] used,  HashSet<ArrayList<Integer>> res) {

        if (i == k) {
            Arrays.sort(combination);
            ArrayList<Integer> candidate = new ArrayList<Integer>(Arrays.asList(combination));
            res.add(candidate);

        } else {

            for (int num = 1; num <= n; num++) {
                if (!used[num]) {
                    combination[i] = num;
                    used[num] = true;

                    combinationsHelper(n, k, i + 1, combination, used, res);

                    used[num] = false;
                }
            }
        }
    }

    public static void print(HashSet<ArrayList<Integer>> res) {
        System.out.println(res.size());

        for (ArrayList<Integer> a: res) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String [] args) {
        int n=3;
        int k = 2;

        combinations(n, k);
    }
}
