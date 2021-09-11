/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/17
 */
public class Solution {

    public static double myPow(double x, int n) {
        if (x == 0) return 0.0;
        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -1 * b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00,10));
    }
}
