public class Partition {

    public static void partition(int [] s, int n, int k) {

        int maxN = n + 1;
        int maxK = k+1;

        int [][] dp = new int [maxN][maxK]; // values of each partition
        int [][] div = new int [maxN][maxK]; // dividers for each partition
        int [] sumSoFar = new int[maxN];

        sumSoFar[0] = 0;
        for (int i=1; i <= n; i++) {
            sumSoFar[i] += sumSoFar[i-1] + s[i-1];
        }

        // boundaries
        // all partition with k=1 equal the sum
        for (int num = 1; num <=n; num++) {
            dp[num][1] = sumSoFar[num];
        }

        // all partitions with one element, equal to the first element
        for (int part = 1; part <=k; part ++) {
            dp[1][part] = s[0];
        }

        for (int num = 2; num <= n; num++ ) {
            for (int part = 2; part <=k; part++) {

                int minCost = Integer.MAX_VALUE;

                for (int i = 1; i <=n; i++) {
                    int cost = Math.max(dp[i][part-1], sumSoFar[num] - sumSoFar[i]);
                    if (minCost > cost) {
                        minCost = cost;
                        div[num][part] = i;
                    }
                }
                dp[num][part] = minCost;

            }
        }

        reconstructPartition(s, div, n, k);

    }

    private static  void reconstructPartition(int [] s, int [][] div, int n, int k) {
        if (k == 1) {
            printBooks(s, 0, n);

        } else {
            reconstructPartition(s, div, div[n][k], k - 1);
            printBooks(s, div[n][k], n);
        }
    }

    private static void printBooks(int [] s, int start, int end) {
        for (int i = start; i<end; i++) {
            System.out.print(s[i]);
            System.out.print(" ");

        }
        System.out.println();

    }

    public static void main(String [] args) {
        int [] s = {1, 2, 3, 4, 5 , 6, 7 ,8 , 9};

        partition(s, 9, 3);
    }
}
