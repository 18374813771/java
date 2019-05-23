package cn.dhx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    public void getClassMessage(Object object){
        Class c= object.getClass();

        System.out.println("类名是："+c.getName());

        //方法method本身也有类类型
        //getMethods()会返回一个类所有的公共方法，包括从父类继承的
        Method[] methods = c.getMethods();
        //getDeclaredMethods()返回的是一个类自己定义的所有方法，包括private的
        Method[] methods1 = c.getDeclaredMethods();

        for (Method method : methods){
            Class returnType =  method.getReturnType();
            System.out.print(returnType+" ");
            System.out.print(method.getName()+"(");
            Class[] params = method.getParameterTypes();
            for (Class param: params) {
                System.out.print(param.getName()+",");
            }
            System.out.print(")");
            System.out.println();
        }

    }

    public void getFiledMessage(Object object){
        Class c = object.getClass();
        //getFields();得到所有公有的成员变量，getDeclaredFields()得到类本身定义的成员变量
        //Field[] fields = c.getFields();
        Field[] fields = c.getDeclaredFields();
        System.out.println("以下是类"+c.getName()+"自身定义的所有的成员变量");
        for (Field field: fields) {
            System.out.println(field.getType().getName()+"  "+field.getName());
        }
    }

    public void  getConstructors(Object obj){
        Class c = obj.getClass();
        //同样有getConstructors()和getDeclaredConstructors()
        Constructor[] constructors = c.getDeclaredConstructors();

        for (Constructor constructor : constructors){
            System.out.print(constructor.getName()+" (");

            Class[] params = constructor.getParameterTypes();
            for (Class param : params){
                System.out.print(param.getName()+",");
            }
            System.out.print(")");
            System.out.println();
        }
    }
}
