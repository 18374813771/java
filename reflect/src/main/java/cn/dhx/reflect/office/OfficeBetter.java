package cn.dhx.reflect.office;

import cn.dhx.reflect.office.type.Document;

/**
 * 以反射的方式动态加载类
 * @author dhx
 * */
public class OfficeBetter {
    public void runDoc(String docName){

        try {
            //这时候编译时并不知道要执行哪个类。运行时才会去找
            Class c = Class.forName(docName);
            /*这个时候就体会到接口的好处了，编码时不知道具体要执行哪个类，
            也不知道要转为哪个类的类型，这时候就要用到多态，使用接口类型。
            此时要加功能是只需要加一个新的类，而不需要修改原来的代码**/
            Document document = (Document)c.newInstance();
            document.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
