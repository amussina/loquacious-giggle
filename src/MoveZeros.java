public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int count = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                count++;
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }

        while (count > 0) {
            nums[i] = 0;
            i++;
            count--;
        }
    }

    public static void print(int [] combination) {
        for (int i = 0; i < combination.length; i++) {
            System.out.print(combination[i]);
        }
        System.out.println();
    }

    public static void main(String [] args) {
        int [] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        print(nums);


    }
}
