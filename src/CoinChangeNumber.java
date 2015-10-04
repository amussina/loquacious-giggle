public class CoinChangeNumber {
    public static int numberOfCoinChanges(int n, int m, int [] denom) {

        Integer [][] dp = new Integer [n + 1][m];

        for (int i=0; i <=n; i++) {
            dp[i][0] = 0;
        }

        for (int j=0; j <m; j++) {
            dp[0][j] = 1;
        }

        for (int i =1; i<=n;i++) {
            for (int j = 0; j<m;j++) {
                int x = (j>=1) ? dp[i][j - 1] : 0;
                int y = (i - denom[j] >= 0) ? dp[i - denom[j]][j] : 0;
                dp[i][j] = x+y;
            }
        }

        return dp[n][m-1];


    }

    public static int numberOfCoinChangesHelper(int n, int m, int [] denom, Integer[][] dp) {
        if (n < 0) {
            return 0;
        }
        if (m <= 0 && n >= 1) {
            return 0;
        }
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        int sum = ((n >= 1) ? numberOfCoinChangesHelper(n, m-1, denom,dp) : 0 ) +
                  ((n-denom[m-1] >= 0) ? numberOfCoinChangesHelper(n-denom[m-1], m, denom, dp) : 0);
        dp[n][m] = sum;

        return sum;
    }



    public static void main(String[] args) {
        int [] denom = {1,5,25};
        int number = numberOfCoinChanges(100, 3, denom);
        System.out.println(number);
    }

}
