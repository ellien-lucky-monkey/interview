package com.interview.experience.actual.solution;

import java.util.Stack;

/**
 * @author Jiangkui
 * @since 2019/12/20 09:54
 */
public class Solution9 {

    public static void main(String[] args) {
//        int x = 121;
//        int y = 1221;
//        int z = -1221;
//        System.out.println("x = [" + isPalindrome(x) + "]");
//        System.out.println("y = [" + isPalindrome(y) + "]");
//        System.out.println("z = [" + isPalindrome(z) + "]");
//        System.out.println("r = [" + romanToInt("MCMXCIV") + "]");

//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//        System.out.println(longestCommonPrefix(new String[]{"c", "c"}));
//        System.out.println(longestCommonPrefix1(new String[]{"c", "c"}));
//        System.out.println(isValid1("()"));
//        System.out.println(isValid1("()[]{}"));
//        System.out.println(isValid1("(]"));
//        System.out.println(isValid1("([)]"));
//        System.out.println(isValid1("{[]}"));
//        System.out.println(isValid1("(])"));

        System.out.println(isValid("()[]{}"));

    }


    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int tmp = 0;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }


        if (tmp == x || tmp / 10 == x) {
            return true;
        } else {
            return false;
        }
    }


    public static int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i <= s.length() - 1) {
            char ch = s.charAt(i);
            char chNext;
            if (i == s.length() - 1) {
                chNext = '0';
            } else {
                chNext = s.charAt(i + 1);
            }

            switch (ch) {

                case 'V':
                    sum = sum + 5;
                    i++;
                    break;
                case 'D':
                    sum = sum + 500;
                    i++;
                    break;
                case 'M':
                    sum = sum + 1000;
                    i++;
                    break;
                case 'L':
                    sum = sum + 50;
                    i++;
                    break;


                case 'I':
                    if (chNext == 'V') {
                        sum = sum + 4;
                        i = i + 2;
                    } else if (chNext == 'X') {
                        sum = sum + 9;
                        i += 2;
                    } else {
                        sum = sum + 1;
                        i++;
                    }
                    break;

                case 'X':
                    if (chNext == 'L') {
                        sum = sum + 40;
                        i += 2;
                    } else if (chNext == 'C') {
                        sum = sum + 90;
                        i += 2;
                    } else {
                        sum = sum + 10;
                        i++;
                    }
                    break;


                case 'C':
                    if (chNext == 'D') {
                        sum = sum + 400;
                        i += 2;
                    } else if (chNext == 'M') {
                        sum = sum + 900;
                        i += 2;
                    } else {
                        sum = sum + 100;
                        i++;
                    }
                    break;
                default:
                    i++;
                    throw new RuntimeException("参数不合法");
            }

        }
        return sum;
    }


    /**
     * 取字符串第一个进行遍历
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        if (strs.length == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int flag = 1;
            for (int j = 1; j <= strs.length - 1; j++) {
                String str = strs[j];
                if (str.length() <= i || str.charAt(i) != c) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0) {
                break;
            }
            res = res + c;
        }
        return res;
    }


    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].contains(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                boolean b1 = c == '}' && peek == '{';
                boolean b2 = c == ']' && peek == '[';
                boolean b3 = c == ')' && peek == '(';
                if (b1 || b2 || b3) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }


    public static boolean isValid1(String s) {


        if (s == null) {
            throw new RuntimeException("参数不合法");
        }
        if (s.equals("")) return true;

        int i = 0, j = s.length() - 1;

        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            boolean b1 = c2 == '}' && c1 == '{';
            boolean b2 = c2 == ']' && c1 == '[';
            boolean b3 = c2 == ')' && c1 == '(';


            if (b1 || b2 || b3) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        if (i == j) {
            return false;
        }

        return true;
    }
}
