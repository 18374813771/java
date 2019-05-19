package cn.dhx.io.Util;

import java.io.File;

/**
 * File工具类
 * @author dhx
 * */
public class FileUtil {

    /**
     * 遍历一个文件目录，及其子目录
     * @param dir 文件夹对象
     * @throw 非法数据异常
     * */
    public void listDirectory(File dir){
        if (dir == null){
            throw new IllegalArgumentException("目录："+dir+"不存在");
        }
        if (!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }

        //得到一个子目录文件（目录）数组
        File[] files = dir.listFiles();
        if (files != null && files.length > 0){
            for (File file : files) {
                if (file.isDirectory()){
                    this.listDirectory(file);
                }else {
                    System.out.println(file.getName()+":"+file.getPath());
                }
            }
        }
    }
}
