package cn.dhx.reflect;

/**
 * @author dhx
 * 加载类的方式
 * */
public class ClassDemo {
    public static void main(String[] args) {
        //foo表示的是Foo的一个实例
        Foo foo = new Foo();
        //Foo本是也是一个实例对象，任何类都是Class的实例对象
        //Class的实例有三种表现方式

        //第一种表现方式-->告诉我们每个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表现方式，已知类的实例通过getClass
        Class c2 = foo.getClass();

        //官网表示说是 c1,c2表示的是Foo类的类类型（classType）

        Class c3 = null;
        try {
            //第三种方式 反射
            c3 = Class.forName("cn.dhx.reflect.Foo");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        try {
            Foo foo1 = (Foo) c3.newInstance();
            foo1.me();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo{
    public  void me(){
        System.out.println("i am Foo");
    }
}