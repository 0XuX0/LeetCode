##LeetCode 72 编辑距离
####Description:
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
+ 插入一个字符
+ 删除一个字符
+ 替换一个字符

####Example:
>输入:word1 = "horse", word2 = "ros"  
输出:3  
>解释：  
>horse -> rorse (将 'h' 替换为 'r')  
>rorse -> rose (删除 'r')  
>rose -> ros (删除 'e')


####Hint:
* 方案 动态规划
> 定义dp函数：dp(i,j) 返回s1[0...i] s2[0...j]的最小编辑距离  
> 状态转移方程  
> if (s1[i] == s2[j]) #啥也没做  
>   return dp(i-1, j-1)  
> else  
>   return min(dp(i,j-1) + 1 #插入, dp(i-1,j) + 1#删除, dp(i-1,j-1) + 1#替换)
