public class EditDistance {

    public static int editDistance(int i, int j, String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int [][] DP = new int[m][n];
        init(DP, m , n);

        return editDistanceHelper(0, 0, s1, s2, DP);
    }

    private static void init(int [][] DP, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }

    }

    public static int editDistanceHelper(int i, int j, String s1, String s2, int [][] DP) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (i == s1.length() && j < s2.length()) {
            return s2.length() - j;
        }
        if (j == s2.length() && i < s1.length()) {
            return s1.length() - i;
        }

        if (DP[i][j] != -1) {
            return DP[i][j];
        }

        // if i j th char is same move on

        if (s1.charAt(i) == s2.charAt(j)) {
            DP[i][j] = editDistanceHelper(i+1, j+1, s1, s2, DP);
            return DP[i][j];
        }

        DP[i][j] = Math.min(
                1 + editDistanceHelper(i +1, j +1, s1, s2, DP),

                Math.min(
                        1 + editDistanceHelper(i, j+1, s1, s2, DP),
                        1 + editDistanceHelper(i+1, j, s1, s2, DP)
                )

        );

        return DP[i][j];
    }

    public static void main(String [] args) {
        String s1 = "";

        String s2 = "pond";

        int dist = editDistance (0, 0, s1, s2);
        System.out.print(dist);
    }
}
