import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static  int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int m = triangle.size();

        Integer [][] DP = new Integer [m][m];
        return minimalTotalHelper(triangle, 0, 0, DP);
    }

    public static  int minimalTotalHelper(List<List<Integer>> triangle, int i, int j, Integer [][] DP) {
        if (i == DP.length) {
            return 0;
        }

        if (DP[i][j] != null) {
            return DP[i][j];
        }

        int minSum = triangle.get(i).get(j) + Math.min(
                minimalTotalHelper(triangle, i+1, j, DP),
                minimalTotalHelper(triangle, i+1, j+1, DP)
        );
        DP[i][j] = minSum;
        return DP[i][j];
    }

    public static void main(String [] args) {
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(3);
        row2.add(4);
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        ArrayList<Integer> row4 = new ArrayList<Integer>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        int max =  minimumTotal(triangle);
        System.out.print(max);
    }
}
