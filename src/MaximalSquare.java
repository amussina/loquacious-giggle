public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] DP = new int [m][n];

        for (int col = 0; col < n; col ++) {
            DP[0][col] = matrix[0][col] == '1' ? 1 : 0;
        }

        for (int row = 0; row < m; row++) {
            DP[row][0] = matrix[row][0] == '1' ? 1 : 0;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col ++) {
                if (matrix[row][col] == '1') {
                    DP[row][col] = 1 + Math.min(
                            Math.min(
                                    DP[row][col-1],
                                    DP[row-1][col-1]
                            ),
                            DP[row-1][col]
                    );
                } else {
                    DP[row][col]=0;
                }
            }
        }

        int max = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col ++) {
                if (max < DP[row][col]) {
                    max= DP[row][col];
                }
            }
        }
        return max*max;

    }

    public static void main(String [] args) throws Exception {
        char [][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1',},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int sq= maximalSquare(matrix);

        System.out.print(sq);
    }

}
