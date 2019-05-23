package cn.dhx.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 验证泛型的作用
 * @author dhx
 * */
public class Generosity {
    public void testGenerosity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();

        Class c1 = list1.getClass();

        Class c2 = list2.getClass();
        System.out.println(c1 == c2);
        //list1可存入所有类型
        //list2只能存入String，否则编译器会报错

        //使用反射绕过编译添加数据
        Method add = c2.getMethod("add",Object.class);
        add.invoke(list2,10);
        System.out.println(list2);
        System.out.println(list2.size());

//      这时候不能用for循环了会有类型转换错误
//        for (String s : list2){
//            System.out.println(s);
//        }

    }
}
