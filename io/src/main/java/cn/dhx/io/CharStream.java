package cn.dhx.io;

import java.io.*;

/**
 * 字符流的操作
 *
 * */
public class CharStream {
    //相当于用字符流实现文件的copy
    public void charSteamDemo(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        //字符流读取时是按照项目默认编码方式，读文件是要按照文件的编码方式。
        InputStreamReader reader = new InputStreamReader(inputStream,"utf-8");

        FileOutputStream outputStream = new FileOutputStream("CharStreamTest.java");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        char[] buf = new char[8*1024];
        int c;
        /*批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个
		  返回的是读到的字符的个数
		*/
        while ((c = reader.read(buf,0,buf.length)) != -1){
            String str = new String(buf,0,c);
            writer.write(str);
            writer.flush();
        }
//        while ((c = reader.read()) != -1){
//            writer.write(c);
//        }

        writer.close();
        inputStream.close();
        reader.close();
        outputStream.close();
    }
}
