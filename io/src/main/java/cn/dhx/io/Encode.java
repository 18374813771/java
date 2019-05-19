package cn.dhx.io;

import java.io.UnsupportedEncodingException;

public class Encode {

    public static void main (String[] args) throws UnsupportedEncodingException {
        String s = "段海学dhx";

        //转换成字节序列,以jbk编码
        byte[] bytes = s.getBytes("gbk");
        //GBK编码中文占用两个字节，英文占用一个字节
        for (Byte b:bytes){
            //把字节转成int以16进制显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }


        System.out.println("");

        //转换成字节序列，以utf-8编码
        bytes =  s.getBytes("utf-8");
        //UTF-8编码中文占用三个字节，英文占用1个字节
        for (Byte b:bytes){
            //把字节转成int以16进制显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();

        //java是双字节编码，是以UTF-16be来编码的.一个中文两个字节，英文占用也是两个字节
        bytes = s.getBytes("utf-16be");
        for (Byte b:bytes){
            //把字节转成int以16进制显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");

        }
        /*
         *当你的字节序列是某种编码时，这个时候想把字节序列变成字符串
         *也需要这种编码方式，否则就会出现乱码
         * */
        System.out.println();

        //使用系统默认的编码会造成乱码
        String s1 = new String(bytes);
        System.out.println(s1);
        //转成java 编码
        String s2 = new String(bytes,"utf-16");
        System.out.println(s2);
        //文本文件就是字节序列，在中文机器上直接创建文本文件，那么文本文件只认识ansi
    }
}
