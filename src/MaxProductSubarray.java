public class MaxProductSubarray {
    public static int maxSubarray(int [] a) {
        if (a==null || a.length ==0 ){
            return 0;
        }
        int maxSoFar = a[0];
        int maxEndingAtIndex = a[0];
        int minEndingAtIndex = a[0];
        int n = a.length;
        for (int i=1; i<n;i++) {
            int maxLocal = maxEndingAtIndex;
            maxEndingAtIndex = Math.max(Math.max(a[i], a[i] * maxEndingAtIndex), a[i] * minEndingAtIndex);
            minEndingAtIndex = Math.min(Math.min(a[i], a[i] * maxLocal) , a[i]*minEndingAtIndex);
            maxSoFar = Math.max(maxSoFar, maxEndingAtIndex);
            System.out.println("Index i:" + i + " , maxEndingHere=" + maxEndingAtIndex + " , minEndingHere=" + minEndingAtIndex+" maxSoFar = " + maxSoFar);
        }

        return maxSoFar;

    }

    public static void main(String [] args) {
        int [] a = {-10, -1, -4,};

        System.out.print(maxSubarray(a));
    }
}
