public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++ ) {
            int buffLen = n - 2*i;
            int [] buff = new int[buffLen];
            int k = 0;
            for (int j = i; j < buffLen; j++) {
                buff[k++] = matrix[i][j];
            }

            for (int j = n-1; j>=0;j--) {
                matrix[j][i] =matrix[i][n - 1 - j];
            }

            for (int j = i; j < buffLen; j++) {
                matrix[j][i] = matrix[n - 1 - i][j];
            }

            for (int j = n-1; j>=0;j--) {
                matrix[n - 1 - i][n - 1 - j] = matrix[n- 1 - j][n-1];
            }

            for (int j = i; j < buffLen; j++) {
                matrix[j][n- 1- i] = buff[j];
            }
        }
    }

    private static void print(int [][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n;i++ ) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }



    public static void main(String[] args) {


        int [][] matrix = {
                {0,  1,  2,  3},
                {4,  5,  6,  7},
                {8,  9,  10,  11},
                {12, 13, 14, 15}};

        print(matrix);

        rotate(matrix);

        print(matrix);

    }


}
