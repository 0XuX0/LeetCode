##LeetCode 39 组合总和
####Description:
>给定一个 *无重复元素* 数组 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。  
>candidates 中的数字可以无限制重复被选取。  
>   
>**说明：**  
> * 所有数字(包括目标数)都是正整数。  
> * 解集不能包含重复的组合。                

####Example:
>输入:candidates = [2,3,6,7], target = 7,  
所求解集为:  
>[  
>&nbsp;&nbsp;&nbsp;&nbsp;[7],   
>&nbsp;&nbsp;&nbsp;&nbsp;[2,2,3]   
>]

>输入:candidates = [2,3,5], target = 8,  
所求解集为:  
>[  
>&nbsp;&nbsp;&nbsp;&nbsp;[2,2,2,2],   
>&nbsp;&nbsp;&nbsp;&nbsp;[2,3,3],   
>&nbsp;&nbsp;&nbsp;&nbsp;[3,5]   
>]

####Hint:
>我们使用递归-回溯-剪枝方法  
>我们维护一个String数组表示我们选取的 candidates 元素，同时 target 减去该值。  
>进入下一层递归，若当前target < 0则return，若target = 0则加入结果数组  
>若target > 0 则将下一个candidates元素加入数组进行新一轮递归求解。  
>若此时 target - 当前元素值小于 < 0则直接return (剪枝 注意candidates数组需要排序)