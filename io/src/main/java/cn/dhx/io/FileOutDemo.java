package cn.dhx.io;

import cn.dhx.io.Util.IOUtil;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {

    public void fileOutWrite(String fileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        //写出了A的低八位
        outputStream.write('A');
        //写出了B的低八位
        outputStream.write('B');

        //write只能写八位，写一个int四次，每次8位
        int a= 10 ;
        outputStream.write(a >>>24);
        outputStream.write(a >>>16);
        outputStream.write(a >>>8);
        outputStream.write(a);

        byte[] str = "中国".getBytes("GBK");
        outputStream.write(str);

        outputStream.close();
        IOUtil.printHex(fileName);
    }
}
