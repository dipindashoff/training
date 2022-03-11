package javaProgrammingPart3;

public class MaxConsecutiveZeroes {

    public static void main(String[] args) {
//        int a[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1};
//        int a[] = {1, 1, 0, 0, 1, 0, 0, 0, 0};
        int a[] = {1, 1, 0, 1, 1, 1};
//        System.out.println(getMaxConsecutiveZeroes(a));
//        System.out.println(getMaxConsecutiveOnesLeetCode(a));
        System.out.println(getMaxConsecutiveOnesLeetCode2(a));
    }

    public static int getMaxConsecutiveZeroes(int a[]) {
        int max = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return (count > max ? count : max);
    }

    public static int getMaxConsecutiveOnesLeetCode(int a[]) {
        int max = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
//            count = count + a[i];
            count++;
            if (a[i] == 0)
                count = 0;
            else
                max = Math.max(max, count);
        }

//        for(int num: a){
//            count = num == 0? 0 : count+1;
//            max = Math.max(max, count);
//        }
        return max;
    }

    public static int getMaxConsecutiveOnesLeetCode2(int a[]) {
        int maxHere = 0, max = 0;
        for (int n : a)
            max = Math.max(max, (maxHere = (n == 0 ? 0 : maxHere + 1)));
        return max;
    }

}
