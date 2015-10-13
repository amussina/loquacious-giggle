public class TwoDBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 3
        int n = matrix[0].length; // 4

        int start = 0;
        int end = m*n-1;

        int len = m*n;

        while (start <= end) {
            int midIndex = start + (end - start)/2; //5

            int col = midIndex%n;
            int row = midIndex/n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = midIndex-1;
            } else {
                start = midIndex + 1;
            }
        }

        return false;

    }

    public static void main(String [] args) {
        int [][] m = {{1, 1}};
        System.out.println(searchMatrix(m, 2));
    }
}
