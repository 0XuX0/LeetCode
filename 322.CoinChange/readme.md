##LeetCode 322 零钱兑换
####Description:
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少硬币的个数。如果没有任何一种硬币组合能组成总金额，返回 -1  

####Example1:
>输入:coins = [1,2,5], amount = 11    
输出:3  
>解释: 11 = 5 + 5 + 1 

####Example2:
>输入:coins = [2], amount = 2    
输出:-1  

####Hint:
> step.1 确定状态  
> step.2 dp函数含义  
> step.3 确定选择并择优  
> step.4 明确结束条件  
