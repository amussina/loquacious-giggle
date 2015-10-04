public class SimplifiedKnapsack {

    public static int maxLoad(int C, int [] a) {
        int [][] dp = new int [C+1][a.length];
        int n = a.length;

        init(dp, C, n);

        return maxLoadHelper(C, a, dp, n - 1);
    }

    private static void init(int [][] dp, int C, int n) {
        for (int i = 0; i < C +1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

    }

    public static int maxLoadHelper(int C, int [] a, int [][] dp, int i) {
        if (dp[C][i] != -1) {
            return dp[C][i];
        }

        // handle special case of null and empty array
        if (C <= 0 || i <= 0) {
            return 0;
        }
        // if the element is bigger than capacity, don't take it
        if (a[i] > C) {
            return maxLoadHelper(C, a, dp, i-1);
        }

        dp[C][i] = Math.max( a[i] + maxLoadHelper(C-a[i], a, dp , i-1), maxLoadHelper(C, a, dp, i - 1));

        return dp[C][i];
    }

    public static void main(String [] args) {
        int C = 76;
        int[] a = {60, 50, 25, 20, 80, 95, 5, 200};

        int m = maxLoad(C, a);
        System.out.println(m);
    }
}
