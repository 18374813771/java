package cn.dhx.io;

import cn.dhx.io.Util.IOUtil;

import java.io.*;

public class DataStreamDemo {

    public void dataInput(String fileName) throws IOException {
        DataInputStream stream = new DataInputStream(new FileInputStream(fileName));
        int i = stream.readInt();
        System.out.println(i);
        i = stream.readInt();
        System.out.println(i);
        long j = stream.readLong();
        System.out.println(j);
        double k = stream.readDouble();

        String s= stream.readUTF();
        System.out.println(s);
        char c = stream.readChar();
        System.out.println(c);

        stream.close();
    }

    public void dateOutput(String fileName) throws IOException{
        DataOutputStream stream = new DataOutputStream(new FileOutputStream(fileName));

        stream.writeInt(10);
        stream.writeInt(-10);
        stream.writeLong(10L);
        stream.writeDouble(10.5);
        //采用utf-8的编码写出
        stream.writeUTF("中国");

        //采用utf-16be的编码写出
        stream.writeChars("中国");

        stream.close();

        IOUtil.printHex(fileName);
    }
}
