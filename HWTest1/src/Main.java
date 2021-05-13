import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int capacity = sc.nextInt();
//        int[] num = new int[capacity];
//        for(int i = 0; i < capacity; i++) {
//            num[i] = sc.nextInt();
//        }
//        int c = sc.nextInt();
//        Arrays.sort(num);
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < num.length - 1; i++) {
//            if (num[i] != num[i + 1]) {
//                list.add(num[i]);
//            }
//        }
//        list.add(num[num.length - 1]);
//        if (list.size() < (c * 2)) {
//            System.out.println(-1);
//        } else {
//            int[] res = new int[list.size()];
//            for(int i = 0; i < list.size(); i++) {
//                res[i] = list.get(i);
//            }
//            int sum = 0;
//            for(int i = 0; i < c; i++) {
//                sum += res[i] + res[res.length - 1 - i];
//            }
//            System.out.println(sum);
//        }
//        String s1 = "ab";
//        String s2 = new String("ab");
//        System.out.println(s1 == "ab");
//        System.out.println(s2 == "ab");
//        System.out.println(method());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char c : chars) {
            if(c == ',') continue;
            sb.append(c);
        }
        String newStr = sb.toString();
        int[] resArray = new int[newStr.length() + 1];
        for(int i = 0; i < newStr.length(); i++) {
            int num = newStr.charAt(i) - '0';
            if(resArray[num] != 0) {
                resArray[num] += 1;
                continue;
            }
            resArray[num] = 1;
        }
        for(int index = 0; index < resArray.length; index++) {
            if(resArray[index] == 2){
                res.append(index);
                res.append(' ');
            }
        }
        System.out.println(res.toString());
    }

    public static String solution(String T) {
        char[] chars = T.toCharArray();
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbM = new StringBuilder();
        StringBuilder sbL = new StringBuilder();
        for(char c : chars) {
            if(c == 'S') {
                sbS.append(c);
            }
            if(c == 'M') {
                sbM.append(c);
            }
            if(c == 'L') {
                sbL.append(c);
            }
        }
        return sbS.toString() + sbM.toString() + sbL.toString();
    }

}
