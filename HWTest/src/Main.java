import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void process(int[] num) {
        List<Integer> doArr = new ArrayList<>();
        List<Integer> copyArr = new ArrayList<>();
        List<Integer> selectedArr = new ArrayList<>();
        for(int i = 0; i < num.length; i++) {
            // 输入数字1
            if (num[i] == 1) {
                doArr.add(1);
            }
            // 复制
            else if (num[i] == 2) {
                if (selectedArr.isEmpty()) continue;
                copyArr.clear();
                copyArr.addAll(selectedArr);
            }
            // 剪切
            else if (num[i] == 3) {
                if (selectedArr.isEmpty()) continue;
                copyArr.clear();
                copyArr.addAll(selectedArr);
            }
            // 粘贴
            else if (num[i] == 4) {
                doArr.addAll(copyArr);
            }
            else if (num[i] == 5) {
                if (doArr.isEmpty()) continue;
                selectedArr.clear();
                selectedArr.addAll(doArr);
                doArr.clear();
            }
        }
        System.out.println(doArr.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length() / 2 + 1;
        int[] num = new int[len];
        int pos = 0;
        for(int i = 0; i < str.toCharArray().length; i++) {
            if (str.toCharArray()[i] == ' ') {
                continue;
            }
            num[pos] = str.toCharArray()[i] - '0';
            pos++;
        }

        process(num);
    }
}
