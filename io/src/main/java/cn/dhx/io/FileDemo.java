package cn.dhx.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public void file() throws IOException {
        File file = new File("E:\\test.txt");
        System.out.println("E:\\test.txt是否存在: "+file.exists());

        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file);
//        file.mkdir();
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
    }
}
