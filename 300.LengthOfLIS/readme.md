##LeetCode 300 最长递增子序列
####Description:
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

####Example:
>输入:nums = [10,9,2,5,3,7,101,18]  
输出:4  
>解释：最长递增子序列是 [2,3,7,101] 因此长度为4


####Hint:
* 方案 动态规划
> 定义dp函数：dp[i] 表示以第i位为结尾的最长子序列长度  
> 如例子 nums = [10,9,2,5,3,7,101,18] 对应的 dp = [1,1,1,2,2,3,4,4]
