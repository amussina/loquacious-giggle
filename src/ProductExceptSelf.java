public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int n = nums.length;

        int [] output = new int [n];

        output[0] = 1;
        output[n-1] = 1;

        int tmp = 1;
        for (int i = 0 ; i < n; i++) {
            output[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = n-1; i>=0; i--) {
            output[i] *= tmp;
            tmp*= nums[i];
        }

        return output;
    }
}
