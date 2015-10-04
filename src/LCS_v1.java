public class LCS_v1 {

    public static void main(String [] args) {
        String s1 = "rondo";

        String s2 = "ponp";

        int dist = lcs(0, 0, s1, s2);
        System.out.print(dist);


    }

    public static int lcs(int i, int j, String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int [][] DP = new int [m][n];

        init(DP, m , n);

        return lcsHelper(i, j, s1, s2, DP);
    }

    private static void init(int [][] DP, int m , int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }
    }

    public static int lcsHelper(int i, int j, String s1, String s2, int [][] DP) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (DP[i][j] != -1) {
            return DP[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            DP[i][j] = 1 + lcsHelper(i+1, j+1, s1, s2, DP);
            return DP[i][j];
        }

        DP[i][j] = Math.max(
                lcsHelper(i, j+1, s1, s2, DP),
                lcsHelper(i+1, j, s1, s2, DP)
        );
        return DP[i][j];
    }
}
