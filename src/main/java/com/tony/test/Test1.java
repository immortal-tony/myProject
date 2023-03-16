package com.tony.test;


import org.apache.commons.lang.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName Test1
 * Description TODO
 * @Author hzf
 * @Date 2020/11/26 9:15
 */
public class Test1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(StringUtils.reverse("abcdef"));
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\acer\\Documents\\test.txt");

    }
}
