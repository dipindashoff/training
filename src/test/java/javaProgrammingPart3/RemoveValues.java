package javaProgrammingPart3;

public class RemoveValues {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
//        removeElement(nums, val);
        removeElement2(nums, val);
    }

    public static void removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[count++] = nums[i];
        }
//        return count;

        System.out.println("count = " + count);
        for (int i : nums)
            System.out.print(i + " ");

    }

    /*
    LeetCode Solution
     */
    public static void removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }

        for (int x : nums)
            System.out.print(x + " ");
    }


}
