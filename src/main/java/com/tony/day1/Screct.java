package com.tony.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Description TODO
 * @Author hzf
 * @Date 2023/3/22 18:14
 */
public class Screct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int retSocre = 0;
        if (in.hasNext()) {
            // 对输入的字符做解析
            String target = in.next();
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
                }else if(0x40 <item && item <0x5B){
                    strType.put("lower", strType.get("lower") + 1);
                }else if(0x60 <item && item <0x7B){
                    strType.put("upper", strType.get("upper") + 1);
                }else if(0x21 <=item && item <=0x7E){
                    strType.put("other", strType.get("other") + 1);
                }
            }
            // 判断长度
            if(target.length()<=4){

            }
        }

    }
}
