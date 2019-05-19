package cn.dhx.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 专门读写文件对的类
 * */
public class FileReaderAndWriter {
    public void fileReaderAndWriter(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        //使用FileReader，FileWriter读写文件是以项目编码来读写的。无法自定义
        FileWriter writer = new FileWriter("FileReaderAndWriterTest.java");
        //以追加的方式写文件，不再删除原来的
        //FileWriter writer = new FileWriter(fileName,true);
        char[] buf = new char[8*1024];
        int c;
        if ((c = reader.read(buf,0,buf.length))!= -1){
            writer.write(buf,0,c);
            writer.flush();
        }
        reader.close();
        writer.close();

    }
}
