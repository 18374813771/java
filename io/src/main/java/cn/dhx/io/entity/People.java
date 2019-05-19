package cn.dhx.io.entity;

import sun.misc.SharedSecrets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class People implements Serializable {
    private int id;
    private String name;

    //transient 关键字不会进行虚拟机默认的序列化，但是可以自己完成元素的序列化
    private transient int age;

    public People() {
    }

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 自己实现对某些字段的序列化，在某种场景下能提高性能。比如arrayList只序列化有效的数组。
     * */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{

        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(age);
    }

    //自定义反序列化
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();

        this.age = s.readInt();
    }


}
