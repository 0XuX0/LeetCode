import java.util.*;


public class Main {
    private static void process(int[] num, int v) {
        int min = num[0];
        int max = num[num.length - 1];
        int maxCount = 0;
        for(int i = 0; i < num.length; i++) {
            int tmpCount = 0;
            HashMap<Integer, Integer> tmpMap = generateMap(v, num[i], min, max);
            if (tmpMap == null) {
                maxCount = 0;
                break;
            }
            for(int j = 0; j < num.length; j++) {
                if(tmpMap.containsKey(num[j])) {
                    tmpCount++;
                }
                tmpCount = tmpCount < tmpMap.size() ? tmpCount : tmpMap.size();
            }
            if (maxCount < tmpCount) {
                maxCount = tmpCount;
            }
        }
        System.out.println(maxCount);
    }
    private static HashMap<Integer,Integer> generateMap(int v, int curPos, int min, int max) {
        if(curPos < min || curPos > max) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(curPos, 1);
        int prePos = curPos - v;
        int postPos = curPos + v;
        while(prePos >= min) {
            map.put(prePos, 1);
            prePos -= v;
        }
        while(postPos <= max) {
            map.put(postPos, 1);
            postPos += v;
        }
        return map;
    }

    private static boolean process(char[] chars) {
        if (chars.length == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char tmp = stack.peek();
                if (c == ')' && tmp != '(') return false;
                if (c == ']' && tmp != '[') return false;
                if (c == '}' && tmp != '{') return false;
                stack.pop();
            }
            else if (c == ' ') { continue; }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static List<List<Integer>> process(List<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();
        if (list.size() == 0) return res;
        List<Integer> tmpList = new ArrayList<>();
        if (list.size() == 1) {
            tmpList.add(list.get(0));
            tmpList.add(list.get(0));
            res.add(tmpList);
            return res;
        }
        int start = 0;
        for (int end = 0; end < list.size();) {
            if (end == list.size() - 1) {
                if (start == end) {
                    tmpList.add(list.get(start));
                    tmpList.add(list.get(end));
                    res.add(tmpList);
                } else {
                    tmpList.add(list.get(start));
                    tmpList.add(list.get(end));
                    res.add(tmpList);
                }
                break;
            }
            if (list.get(end) + 1 == list.get(end + 1)) {
                end++;
                continue;
            }
            tmpList.add(list.get(start));
            tmpList.add(list.get(end));
            res.add(tmpList);
            tmpList = new ArrayList<>();
            start = end + 1;
            end = end + 1;
        }
        return res;
    }

    private static String findMaxLengthSubString(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (chars[i] == chars[j]) {
                    if(judge(chars, i, j)) res.add(str.substring(i,j + 1));
                }
            }
        }
        // 遍历取最长
        int max = 0;
        String resStr = "";
        for (String re : res) {
            if (re.length() > max) resStr = re;
        }
        return resStr;
    }

    private static boolean judge(char[] chars, int start, int end) {
        int repeatCount = (end - start) / 2;
        for (int i = 0; i < repeatCount; i++) {
            if (chars[start + i] != chars[end - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(findMaxLengthSubString(str));
        }
    }
}
