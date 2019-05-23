package cn.dhx.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法的反射
 * @author dhx
 * */
public class MethodInvoke {
    public void methodInvoke(Object object){

        Class c= object.getClass();

        try {

            //直接传参数或者传参数数组
//            Method method = c.getMethod("print",new Class[]{String.class,String.class});
            //通过方法名和参数唯一确定一个方法
            Method method = c.getMethod("print",String.class,String.class);
            try {
                //和c.newInstance.print调用完全相同。这里是执行传入类的print(String a,String b)方法
                method.invoke(object,"abc","def");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
