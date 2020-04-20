##LeetCode 46 全排列
####Description:
>给定一个 **没有重复** 数字的序列，返回其所有可能的全排列

####Example:
>输入:[1,1,2]  
输出:  
>[  
&nbsp;&nbsp;&nbsp;&nbsp;[1,1,2],  
&nbsp;&nbsp;&nbsp;&nbsp;[1,2,1],  
&nbsp;&nbsp;&nbsp;&nbsp;[2,1,1]  
]  
####Hint:
>回溯 加 递归的方法。  
#####方案一
>维护一个布尔类型一维数组 isVisited[]，若为true则表示该位置的对应元素已被使用，反之则表示未被使用。  
>维护一个列表tempList，表示当前排列组合。  
>遍历给定数组，若当前元素未被使用则加入tempList，进入下层递归，回溯条件是tempList的长度和目标列表列表长度相等  
>进入下层递归以及回溯时需注意isVisited数组的更新。  
#####剪枝条件
>当前位置非第一个位置  
>当前位置的值与前一位置的值相等  
>前一位置的值未被使用(表示当前处于同一递归层次且在之前的递归中已经走过该分支)