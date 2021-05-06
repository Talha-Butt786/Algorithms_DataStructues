public class MaxSub_array {

    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int runningWindowSum = 0;

            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                    start = left;
                    end = right;
                }
            }
        }
        return maximumSubArraySum;
    }

    public static void main(String[] args) {
        int a [] = {-2,4,3,2};
        System.out.println(maxSubArray(a));
    }
}
