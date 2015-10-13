public class FindPeakElement {

        public static int findPeakElement(int[] nums) {

            if (nums == null || nums.length == 0) {
                return Integer.MIN_VALUE;
            }
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }



            int peak = 0;
            for (int i = 0; i< n - 1; i++) {
                if (nums[i] < nums[i+1]) {
                    peak = i+1;
                    continue;
                } else {
                    break;
                }

            }

            return peak;
        }

    public static void main(String [] args) {
        int [] nums = {5, 0, 3};

        int p = findPeakElement(nums);
        System.out.print(p);
    }

}
