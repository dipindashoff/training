package javaProgrammingPart3;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1, 1, 2};
//        int[] nums = {0, 1, 1, 2, 2};
//        int[] nums = {0, 1, 2, 3, 4};
//        returnCountOfUniqueElements(nums);
//        returnCountOfUniqueElements2(nums);
        returnCountOfUniqueElements3(nums);

    }

    /*
    My Solution
     */
    public static void returnCountOfUniqueElements(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count++] = nums[i];
            }
        }

        nums[count++] = nums[nums.length - 1];
        System.out.println("count: " + count);

        while (count < nums.length) {
            nums[count++] = 0;
        }

        for (int i : nums)
            System.out.print(i + " ");

    }

    /*
    Leetcode Solution
     */
    public static void returnCountOfUniqueElements2(int[] nums) {

//        if()
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }

        System.out.println("Count = " + count);
        for (int i : nums)
            System.out.print(i + " ");

    }

    /*
    Another popular Leetcode Solution
     */

    public static void returnCountOfUniqueElements3(int[] nums) {

        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;

        System.out.println("Count = " + i);
        for (int x : nums)
            System.out.print(x + " ");

    }
}
