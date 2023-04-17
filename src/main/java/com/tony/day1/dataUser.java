package com.tony.day1;


/**
 * @ClassName Description TODO
 * @Author hzf
 * @Date 2023/4/6 11:15
 */
public class dataUser {
    /**
     * 面试题 17.08. 马戏团人塔
     * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，
     * 在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
     * <p>
     * 示例：
     * <p>
     * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
     * 输出：6
     * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
     * 提示：
     * <p>
     * height.length == weight.length <= 10000
     *
     * @return
     */
    public static void main(String[] args) {

        //  最长上升的子序列  要求输出长度


        int i = lengthOfLIS(new int[]{23, 42, 12, 23, 24, 18, 90, 30, 20});
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            //往前搜索
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                    max = Math.max(dp[i + 1], max);
                }
            }
            //前面的j都比i大
            if (dp[i + 1] == 0) dp[i + 1] = 1;
        }
        return max;
    }

    //  动态规划最长上升序列


    public static int lengthofLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //  记录开始的最长上升子序列
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {

            }
        }

    }
}
