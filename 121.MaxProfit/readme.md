##LeetCode 121 买卖股票的最佳时机1
####Description:
给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


####Example:
>输入：[7,1,5,3,6,4]
>输出：5
>解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

####Hint:
* 方案 动态规划
> dp[n] 的 含义是从当前节点开始打劫可获得的最大金额  
> 两种情况：  
> {
>   第n个房间挖:dp(n) = f(n) + Sum(f(n.l.l), f(n.l.r), f(n.r.l), f(n.r.r))  
>   第n个房间不挖:dp(n) = Sum(dp(n.l), dp(n.r))
> }
> 状态转移方程 dp(n) = Max(Sum(dp(n.l), dp(n.r)), 
>  f(n) + Sum(f(n.l.l), f(n.l.r), f(n.r.l), f(n.r.r)))
