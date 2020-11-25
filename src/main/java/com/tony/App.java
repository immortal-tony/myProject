package com.tony;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * 学习Java中的字符输入、输出流
 * @author 彼岸夜微凉
 */
public class App {
    public static void main(String args[]){
        String contect = "彼岸夜微凉！";//用来往文件中写的字符串
        File file = new File("c:\\Users\\Desktop\\file\\OutputStream.txt");
        char in[] = contect.toCharArray();//将字符串转换为字符数组，因为 FileWriter(char [])
        try{

            //字符流的写入数据
            FileWriter writer = new FileWriter(file);
            writer.write(in);
            writer.close();//值得注意的是每次对文件操作后都要进行显示的关闭文件流

            //字符流的读出数据
            FileReader reader = new FileReader(file);
            char[] deposit = new char[100];
            int count = 0;
            while( reader.read(deposit) != -1 ){
                String string = new String(deposit,0,deposit.length);
                System.out.println(string);
                reader.close();//值得注意的是每次对文件操作后都要进行显示的关闭文件流

            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}