import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/21
 **/
public class Solution {
    public static String getPermutation(int n, int k) {
        k = k - 1;
        List<Integer> nums = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int quotient;
        for(int i = 1; i<= n ; i++) {
            nums.add(i);
        }
        while(n > 0) {
            int factorial = getFactorial(n - 1);

            quotient = k / factorial;

            res.add(nums.get(quotient));
            nums.remove(quotient);
            k -= factorial * quotient;
            n -= 1;
        }
        return res.toString();
    }

    private static int getFactorial(int n) {
        int factorial = 1;
        for(int i = 1;i<=n;i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 6;
        String res = getPermutation(n,2);
        System.out.println(res);
        for(int index = 1; index <= k; index++) {
            String res1 = getPermutation(n,index);
            System.out.println(res1);
        }
    }
}
