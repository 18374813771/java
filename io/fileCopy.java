package cn.dhx.io.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dhx
 * */
public class IOUtil {

    /**
     * 按16进制输出一个文件的内容，每十个字符换行
     *
     * */
    public static void printHex(String fileName) {
        try {
            FileInputStream  inputStream = new FileInputStream(fileName);
            int b;
            int i = 1;
            while ((b = inputStream.read()) !=-1){

                //如果输出的16进制是一位就在前面补0
                if (b < 0xf){
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(b)+"  ");
                if (i++%10 == 0){
                    System.out.println();
                }
            }

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按16进制输出一个文件的内容，每十个字符换行,以字节数组的方式读取
     *
     * */
    public static void printHexByByteArray(String fileName){
        try {
            FileInputStream  inputStream = new FileInputStream(fileName);
            byte[] buf = new byte[10*1024];

            //把文件的内容读到字节数组b中，从0开始，最多放字节数组的长度个，返回值是读到的个数
            int i = inputStream.read(buf,0,buf.length);
            for (int j=0;j<i;j++){
                if (buf[j] < 0xf){
                    System.out.print("0");
                }
                //& 0xff只取后八位
                System.out.print(Integer.toHexString(buf[j] & 0xff)+"  ");

                if (j%10==0 && j!=0){
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println("文件 "+fileName+"共有 "+i+"个字节");
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileCopy(File srcFile,File destFile) throws IOException{
        if (!srcFile.exists()){
            throw new IllegalArgumentException("源文件"+srcFile+"不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException("源文件"+srcFile+"不是一个文件");
        }

        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(destFile);
        byte[] buf = new byte[10*1024];
        int b;
        //b是读取文件的个数
        b = inputStream.read(buf,0,buf.length);
        outputStream.write(buf,0,b);
        outputStream.flush();

        inputStream.close();
        outputStream.close();
    }
}
