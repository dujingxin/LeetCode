package com.durjx.leetcode.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author durjx
 * @date 2021/4/13
 * @description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 **/
@Slf4j
public class TwoSum {
    public static void main(String[] args) {
        int[] j = {2, 7, 11, 15};
        int target1 = 9;
        int[] i = {3, 2, 4};
        int target2 = 6;
        int[] l = {3, 3};
        int target3 = 6;

        TwoSum twoSum = new TwoSum();

        log.info(Arrays.toString(twoSum.twoSum(j, target1)));
        log.info(Arrays.toString(twoSum.twoSum(i, target2)));
        log.info(Arrays.toString(twoSum.twoSum(l, target3)));

        log.info(Arrays.toString(twoSum.twoSum1(j, target1)));
        log.info(Arrays.toString(twoSum.twoSum1(i, target2)));
        log.info(Arrays.toString(twoSum.twoSum1(l, target3)));
    }

    /**
     * 暴力破解
     * 时间复杂度：O(N^2)
     *
     * @param nums   int 数组
     * @param target 目标值
     * @return 返回
     */
    public int[] twoSum(int[] nums, int target) {
        for (int m = 0; m < nums.length; m++) {
            for (int n = m + 1; n < nums.length; n++) {
                if (((nums[m] + nums[n]) == target)) {
                    return new int[]{m, n};
                }
            }
        }
        return new int[0];
    }
    /////////////////////////////////////////////////////////////////////

    /**
     * 哈希表
     * 思路及算法
     * <p>
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * <p>
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * <p>
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     * @param nums   int 数组
     * @param target 目标值
     * @return 返回
     */
    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
