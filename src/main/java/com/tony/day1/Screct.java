package com.tony.day1;

import java.util.*;

/**
 * @ClassName Description TODO
 * @Author hzf
 * @Date 2023/3/22 18:14
 */
public class Screct {
    public static void main(String[] args) {

        System.out.println(findsubStr("ccaccccacc"));
        System.out.println(maxGcd(18, 24));
        gcdOfStrings("ABCABC", "ABC");
        Scanner in = new Scanner(System.in);
        findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});

//        System.out.println(new Screct());

//        if (in.hasNext()) {
//            // 对输入的字符做解析
//            String target = in.next();
//            deal5(target);
//            deal6(Integer.valueOf(target));
//            deal7(target);
//            deal8(target);
//            deal9(target);
//            deal10(target);
//        }
        while (in.hasNext()) {
            String target = in.nextLine();
            deal11(in, target);
            deal12(in, target);
        }
    }

    public static void deal12(Scanner sr, String s) {
        int k = Integer.parseInt(sr.nextLine()); //1=<k<=n
        System.out.println(s.substring(0, k)); //截取str1中位置0~(k-1)的字符串
        //利用substring(int A,int B)方法，截取字符串中位置A到B-1的字符串
        sr.close();
    }

    public static void deal11(Scanner sr, String s) {
        int k = Integer.parseInt(sr.nextLine()); //1=<k<=n
        System.out.println(s.substring(0,
                k)); //截取str1中位置0~(k-1)的字符串
        //利用substring(int A,int B)方法，截取字符串中位置A到B-1的字符串
        sr.close();
    }

    //  字符的统计
    public static void deal10(String s) {
        //统计其中英文字符，空格字符，数字字符，其他字符的个数
        int letters = 0;
        int spaces = 0;
        int digits = 0;
        int others = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isSpaceChar(c)) {
                spaces++;
            } else {
                others++;
            }
        }
//      统计其中英文字符，空格字符，数字字符，其他字符的个数
        System.out.println(letters);
        System.out.println(spaces);
        System.out.println(digits);
        System.out.println(others);
    }


    //  哈希
    public static void deal9(String target) {
        HashSet<Character> hs = new HashSet<Character>();
        for (int i = 0; i < target.length(); i++) {
            hs.add(target.charAt(i));
        }
        System.out.println(hs.size());
    }

    //  16进制的字符串
    public static void deal8(String target) {
        String numnber = target.split("0x")[1];
        // A 65 a 97 0 48 9 57
        int ret = 0;
        for (int i = 0; i < numnber.length(); i++) {
            ret = ret * 16 + (Character.isDigit(numnber.charAt(i)) ? numnber.charAt(i) - '0' : numnber.charAt(i) - '7');
        }
        System.out.println(ret);
    }

    // 输出的字符串带空格  字符串的倒序
    public static void deal7(String target) {
        Scanner in = new Scanner(System.in);
        System.out.println(new StringBuffer(in.nextLine()).reverse());
    }

    public static String deal7Reserve(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    // 输出等差数列
    public static void deal6(int target) {
        Math.round(3 * target * target / 2.0 + 1 / 2.0 * target);

    }

    //  密码的输出
    public static void deal5(String target) {
        int retSocre = 0;

        Map<String, Integer> strType = new HashMap() {
            {
                put("digital", 0);
                put("lower", 0);
                put("upper", 0);
                put("other", 0);
            }
        };
        char item;
        for (int i = 0; i < target.length(); i++) {
            item = target.charAt(i);
            if (0x2F < item && item < 0x3A) {
                strType.put("digital", strType.get("digital") + 1);
            } else if (0x60 < item && item < 0x7B) {
                strType.put("lower", strType.get("lower") + 1);
            } else if (0x40 < item && item < 0x5B) {
                strType.put("upper", strType.get("upper") + 1);
            } else if (0x21 <= item && item <= 0x7E) {
                strType.put("other", strType.get("other") + 1);
            }
        }
        // 判断长度
        if (target.length() <= 4) {
            retSocre += 5;
        } else if (target.length() <= 7) {
            retSocre += 10;
        } else {
            retSocre += 25;
        }

        // 判断字母
        if (strType.get("lower") > 0 && strType.get("upper") > 0) {
            retSocre += 20;
        } else if (strType.get("lower") > 0 || strType.get("upper") < 0) {
            // 字母全是大小写
            retSocre += 10;
        }
        // 判断数字
        if (strType.get("digital") > 1) {
            retSocre += 20;
        } else if (strType.get("digital") == 1) {
            retSocre += 10;
        }
        // 符号
        if (strType.get("other") > 1) {
            retSocre += 25;
        } else if (strType.get("other") == 1) {
            retSocre += 10;
        }

        // 奖励  最大的标准做匹配
        if (strType.get("digital") > 0) {
            if (strType.get("other") > 0) {
                if (strType.get("lower") > 0 && strType.get("upper") > 0) {
                    retSocre += 5;
                } else if (strType.get("lower") > 0 || strType.get("upper") > 0) {
                    retSocre += 3;
                }
            } else {
                if (strType.get("lower") > 0 || strType.get("upper") > 0) {
                    retSocre += 2;
                }
            }
        }
        // 评分评价
        if (retSocre >= 90) {
            System.out.println("VERY_SECURE");
        } else if (retSocre >= 80) {
            System.out.println("SECURE");
        } else if (retSocre >= 70) {
            System.out.println("VERY_STRONG");
        } else if (retSocre >= 60) {
            System.out.println("STRONG");
        } else if (retSocre >= 50) {
            System.out.println("AVERAGE");
        } else if (retSocre >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }

    //  最短无序列升序子数组  快速排序  归并排序 有拆分之后的整合
    public static int findUnsortedSubarray(int[] nums) {

        System.arraycopy(nums, 0, new int[nums.length], 0, nums.length);
        Arrays.sort(nums);

        int[] original = nums.clone();
        quickSort(nums, 0, nums.length - 1);
        int[] sortList = nums;
        int retBegin = 0;
        int retEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sortList[i] != original[i]) {
                retBegin = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) { // while 循环的改装
            if (sortList[i] != original[i]) {
                retEnd = i;
                break;
            }
        }
        if (retBegin == retEnd) {
            return 0;
        } else {
            return retEnd - retBegin + 1;
        }
    }

    /**
     * target = (arr[0]+arr[arr.length-1])/2;
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int i = begin;
        int j = end;
        int basicValue = arr[begin];
        while (i < j) {
            while (i < j && arr[j] >= basicValue) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < basicValue) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = basicValue;
        quickSort(arr, begin, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static String gcdOfStrings(String str1, String str2) {
        String str1Com = getShortComStr(str1);
        String str2Com = getShortComStr(str2);
        if (str1Com.equals(str2Com) && str1Com.length() > 0) {
            StringBuilder ret = new StringBuilder();
            int maxGodVal = maxGcd(str1.length(), str2.length());
            for (int i = 0; i < maxGodVal / str1Com.length(); i++) {
                ret.append(str1Com);
            }
            return ret.toString();
        } else {
            return "";
        }
    }

    //  查找子字符串
    public static int findsubStr(String s) {
        return new StringBuffer().append(s).append(s).toString().indexOf(s, 1) + 1;
    }

    public static String getShortComStr(String str1) {
        int splitLength = str1.indexOf(str1.charAt(0), 1);
        if (splitLength > 0) {
            for (int i = splitLength; i < str1.length(); i++) {
                if (!(str1.charAt(i % splitLength) == str1.charAt(i))) {  //  这种方法有点偷懒;使用上面的方法
                    return "";
                }
            }
            return str1.substring(0, splitLength);
        }
        return str1;
    }

    //  求最大公因数
    public static int maxGcd(int a, int b) {
        return b == 0 ? a : maxGcd(b, a % b);
    }

}
