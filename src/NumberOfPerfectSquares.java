import java.util.ArrayList;

public class NumberOfPerfectSquares {

    public static int numSquares(int n) {
        Integer [] DP = new Integer [n+1];

        ArrayList<Integer> squares = new ArrayList<Integer>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int sq = i*i;
            squares.add(sq);
            DP[sq] = 1;
        }

        return numberOfPerfectSquaresHelper(n, DP, squares);
    }

    public static int numberOfPerfectSquaresHelper(int n, Integer [] DP,  ArrayList<Integer> squares){
        if (DP[n] != null) {
            return DP[n];
        }

        int curNum = Integer.MAX_VALUE;

        for (int i = 0; i < squares.size(); i++) {

            //System.out.println(squares.get(i));
            if (squares.get(i) > n) {
                break;
            }
            int numSq = 1 + numberOfPerfectSquaresHelper(n - squares.get(i), DP, squares);
            if (curNum > numSq) {
                curNum = numSq;
            }

        }

        DP[n] = curNum;
        return  DP[n];
    }

    public static void main(String [] args) {

        int num = numSquares(10);//8=1+dp(7), 1+dp(4)
        System.out.print(num);


    }

}
