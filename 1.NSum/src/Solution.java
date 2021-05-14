import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/14
 */
public class Solution {

    /**
     * 两数之和
     *  input: nums = [2,7,11,15], target = 9
     *  output: [0,1]
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 三数之和 返回 a + b + c = 0
     *  input: nums = [-1,0,1,2,-1,-4]
     *  output: [[-1,-1,2],[-1,0,1]]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        return subThreeSum(list, 0, 0);
    }

    /**
     * 四数之和 返回 a + b + c + d = target
     *  input: nums = [-1,0,1,2,-2,0]
     *  output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        return subFourSum(list,0, target);
    }

    private static List<List<Integer>> subFourSum(List<Integer> list, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = list.size();
        for (int i = start; i < len; i++) {
            List<List<Integer>> tmp = subThreeSum(list, i + 1, target - list.get(i));
            for (List<Integer> l : tmp) {
                Collections.reverse(l);
                l.add(list.get(i));
                Collections.reverse(l);
            }
            res.addAll(tmp);
            while(i < len - 1 && (list.get(i).intValue() == list.get(i + 1).intValue())) i++;
        }
        return res;
    }

    private static List<List<Integer>> subThreeSum(List<Integer> list, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = list.size();
        for (int i = start; i < len; i++) {
            List<List<Integer>> tmp = subTwoSum(list, i + 1, target - list.get(i));
            for(List<Integer> l : tmp) {
                Collections.reverse(l);
                l.add(list.get(i));
                Collections.reverse(l);
            }
            res.addAll(tmp);
            while(i < len - 1 && (list.get(i).intValue() == list.get(i + 1).intValue())) i++;
        }
        return res;
    }

    private static List<List<Integer>> subTwoSum(List<Integer> list, int start, int target) {
        int left = start;
        int right = list.size() - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int L = list.get(left);
            int R = list.get(right);
            int sum = L + R;

            if (sum < target) {
                while(left < right && list.get(left) == L) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && list.get(right) == R) {
                    right--;
                }
            }
            else {
                res.add(new ArrayList<>(Arrays.asList(L,R)));
                while(left < right && list.get(left) == L) {
                    left++;
                }
                while (left < right && list.get(right) == R) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-2,0};
//        List<List<Integer>> res = subTwoSum(Arrays.stream(nums).boxed().collect(Collectors.toList()), 1, 9);
//        List<List<Integer>> res = threeSum(nums);
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println("Hello World");
    }
}
