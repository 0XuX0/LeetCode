##LeetCode 47 全排列 II
####Description:
>给定一个 **可包含重复** 数字的序列，返回其所有可能的全排列

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
##### 方案二
>寻找排列组合的过程可看做是元素不断交换的过程。当前位置后面的每个元素和当前第一个元素遍历交换  
>第一层递归：{1,{2,3}} {2,{1,3}} {3,{1,2}}  
>第二层递归：{1,2,{3}} {1,3,{2}} {2,1,{3}} {2,3,{1}} {3,1,{2}} {3,2,{1}}  
>进入下层递归以及回溯时需注意再次交换元素