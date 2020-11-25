package com.tony.day2;

import java.util.ArrayList;
import java.util.List;

public class Palindrme {

    public static void main(String[] args) {
        int number = 98;
        int max = 12000;
        int min = 10;
        Palindrme palindrme = new Palindrme();
        List<Integer> result = palindrme.dealStartNumber(number, max, min);
        System.out.println(result.toString());
    }

    int retFlag;
    /**
     * 是否添加第一个指定元素
     * @param targetNumber
     * @param max
     * @param min
     * @return
     */
    public List<Integer> dealStartNumber(int targetNumber, int max, int min) {
        this.maxNum = targetNumber;
        this.minNum = targetNumber;
        int numberLength = length(targetNumber);
        int tenToTen = (int) Math.pow(10, numberLength - 1);
        this.ret = targetNumber;
        retFlag = palindrme(targetNumber, tenToTen);
        if (0 == retFlag) {
            this.result.add(this.ret);
        }
        dealAll(targetNumber, max, min);
        return result;
    }

    // false表示选择比他小的，true表示选择比他大的
    public Boolean flag = false;
    // 得到的结果list
    public List<Integer> result = new ArrayList<>();
    public int maxNum;
    public int minNum;
    /**
     * 循环遍历回文
     * @param targetNumber
     * @param max
     * @param min
     */
    public void dealAll(int targetNumber, int max, int min) {
        while (!((minNum == min) && (maxNum == max))) {
            if (minNum == min) {
                //达到临界最小值
                this.flag = true;
            }
            if (maxNum == max) {
                //达到临界最大值
                this.flag = false;
            }
            // 判断比他大的值是否回文
            if (flag == true) {
                maxNum = maxNum + 1;
                this.flag = false;
                targetNumber = maxNum;
            } else {
                // 判断比他小的值是否回文
                minNum = minNum - 1;
                this.flag = true;
                targetNumber = minNum;
            }
            if(targetNumber==10011){
                int a=1;
            }
            int numberLength = length(targetNumber);
            int tenToTen = (int) Math.pow(10, numberLength - 1);
            this.ret = targetNumber;
            retFlag = palindrme(targetNumber, tenToTen);
            if (retFlag == -1) {
                continue;
            } else {
                this.result.add(ret);
            }
        }
        return;
    }

    public int head;
    public int tail;
    public int ret;

    /**
     * 验证是否是回文，若是则返回，不是返回-1
     * @param number
     * @return
     */
    public int palindrme(int number, int tenToTen) {
        if (length(number) < 2) {
            return 0;
        }
        head = number / tenToTen;
        tail = number % 10;
        if (head == tail) {
            number = (number - head * tenToTen) / 10;
            tenToTen = tenToTen / 10;
            palindrme(number, tenToTen);
        } else {
            return -1;
        }
        return 0;
    }

    /**
     * 计算数的位长度
     *
     * @param n
     * @return
     */
    public int length(int n) {
        if (0 == n) {
            return 0;
        } else {
            return length(n / 10) + 1;
        }
    }
}
