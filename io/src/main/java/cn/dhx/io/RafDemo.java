package cn.dhx.io;

import sun.nio.cs.ext.GBK;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {
    public void raf() throws IOException {
        //在项目目录下创建文件夹
        File dir = new File("demoDir");
        if (!dir.exists()){
            dir.mkdir();

        }
        File file = new File(dir,"raf.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file,"rw");

        System.out.println("当前指针位置"+raf.getFilePointer());

        //只写了一个字节
        raf.write('A');

        System.out.println("当前指针位置"+raf.getFilePointer());

        raf.write('B');

        System.out.println("当前指针位置"+raf.getFilePointer());

        //每次只能写1个字节，把i写进去要写4次
        int i = 0x7fffffff;

        //髙八位
        raf.write(i >>> 24);
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println("当前指针位置"+raf.getFilePointer());

        //可以直接写int
        raf.writeInt(i);

        String s = "中";
        byte[] bytes = s.getBytes("GBK");
        raf.write(bytes);
        System.out.println("当前指针位置"+raf.getFilePointer());
        System.out.println("当前文件长度"+raf.length());

        //读文件，必须把指针移到首部
        raf.seek(0);
        //一次性读取整个文件内容
        byte[] fileBytes = new byte[(int)raf.length()];

        raf.read(fileBytes);
        System.out.println(Arrays.toString(fileBytes));

        raf.close();
    }

}
