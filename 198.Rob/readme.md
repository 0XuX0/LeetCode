##LeetCode 198 打家劫舍
####Description:
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 
####Example:
>输入:[1,2,3,1]  
输出:4  
>解释：  
>偷窃 1号房屋(金额=1)，然后偷窃3号房屋(金额=3) 偷窃到的最高金额=1+3=4

>输入:[2,7,9,3,1]
>输出:12
>解释 略


####Hint:
* 方案一 动态规划 从左向右
> 处理n小于等于2的情况
> dp(n)的含义是从0开始挖到第n个房间最大可以获得多少金额
> 两种情况：
> {
>   第n个房间挖：dp(n) = f(n) + previousMax  (previousMax 是指n-1以前房屋的最大金额)
>   第n个房间不挖:dp(n) = dp(n-1)
> }
> 状态转移方程 dp(n) = Max(dp(n - 1) , previousMax + f(n)), n > 2

+ 方案二 动态规划 从右向左
> 处理n小于等于2的情况
> dp(n)的含义是从第n个房间开始挖最大可以获得多少金额
> 两种情况：
> {
>   第n个房间挖:dp(n) = f(n) + nextMax  (nextMax 是指n+1之后房屋的最大金额)
>   第n个房间不挖:dp(n) = dp(n + 1)
> }
> 状态转移方程 dp(n) = Max(dp(n + 1), nextMax + f(n)) , n < length - 2

+ 思考:
> 在状态迁移方程中有个 previousMax or nextMax 变量，有点奇特，不太符合正常情况下的状态转移方程
> 原因是在 {2,1,1,2} case中 未能得到正确的预期
> 解决方法可以在数组前端或后端预留两个位置
> 因此状态转移方程可变为
> dp(n) = Max(dp(n-1), dp(n-2) + f(n))

> 进一步优化可考虑空间复杂度