package cn.dhx.reflect.office;

import cn.dhx.reflect.office.type.Excel;
import cn.dhx.reflect.office.type.Word;

/**
 * 传统编译时加载类
 * */
public class Office {

    public void runOffice(String docType){
        //类Word和Office在编码是就必须已经存在
        if (docType !=null){
            if (docType.equals("word")){
                Word word = new Word();
                word.start();
            }
            if (docType.equals("excel")){
                Excel excel = new Excel();
                excel.start();
            }
        }
    }
}
