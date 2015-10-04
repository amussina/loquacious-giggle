public class MaximumSumSubarray {

    public static int maxSubarray(int [] a) {
        if (a==null || a.length ==0 ){
            return 0;
        }
        int maxSoFar = 0;
        int maxEndingAtIndex = 0;
        int n = a.length;
        for (int i=0; i<n;i++) {

            maxEndingAtIndex = Math.max(a[i], a[i] + maxEndingAtIndex);
            maxSoFar = Math.max(maxSoFar, maxEndingAtIndex);
            System.out.println("Index i:" + i + " , maxEndingHere=" + maxEndingAtIndex + " , maxSoFar = " + maxSoFar);
        }

        return maxSoFar;

    }

    public static void main(String [] args) {
        int [] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.print(maxSubarray(a));
    }
}
