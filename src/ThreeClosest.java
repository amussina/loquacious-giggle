import java.util.Arrays;

public class ThreeClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);

        int DIFF = Integer.MAX_VALUE;

        int sum = 0;
        int res = 0;
        for (int i = 0 ; i<= n-3;i++) {

            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int a = nums[i];

            int start = i+1;
            int end = n-1;

            while (start < end) {
                int b = nums[start];
                int c = nums[end];

                sum = a + b + c;
                int curDiff = sum - target;

                if (Math.abs(curDiff) <= DIFF) {
                    DIFF = Math.abs(curDiff);
                    res = sum;
                }

                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    return sum;
                }



            }
        }

        return res;
    }

    public static void main(String [] args) {
        int [] S = {0,2,1,-3};
        int target = 1;

        int s = threeSumClosest(S, target);
        System.out.print(s);
    }

}
