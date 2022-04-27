package package1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther guolei
 * @create 1-11-1 1
 */
public class GenericTest {
    @Test
    public void test1(){
        GenericClass<String> obj = new GenericClass<>(10,"Tom","SB");
        System.out.println(obj);
        System.out.println(obj.showE(123));
    }

    @Test
    public void test2(){
        String obj1 = new String("   ");
        Object obj2 = new Object();

        obj2 = obj1;//不报错

        String[] arr1 = new String[1];
        Object[] arr3 = new Object[1];

        arr3 = arr1; //不报错

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<SuperClass> list2 = new ArrayList<>();
        ArrayList<SubClass> list3 = new ArrayList<>();
        list2.add(new SuperClass("SuperClass"));
        list3.add(new SubClass("SubClass"));


        //编译不通过  A是B的父类 G<A>和G<B>无子父类关系
//        list1 = list2;
//        list2 = list3;
        //用泛型通配符充当G<A>和G<B>的父类
        ArrayList<?> list4 = null;
        list4 = list2;
        list4 = list3;

        //list4.add(?); //泛型通配符无法执行添加操作
        list4.add(null); //但是可以添加null

        Object o = list4.get(0); //泛型通配符可以读取，返回Object

        print(list2);
        print(list3);
    }

    @Test
    public void test3(){
        //有限制的泛型通配符
        ArrayList<? extends SuperClass> list1 = null;
        ArrayList<? super SuperClass> list2 = null;

        ArrayList<SubClass> list3 = null;
        ArrayList<SuperClass> list4 = null;
        ArrayList<Object> list5 = null;

        list1 = list3;
        list1 = list4;
        //list1 = list5; 报错,list1只能是SuperClass及其子类

        //list2 = list3; 报错,list2只能是SuperClass及其父类
        list2 = list4;
        list2 = list5;

        //读取
        SuperClass aClass = list1.get(0); //读取数据用区间内最大的接(负无穷，SuperClass]
        Object object = list2.get(0); //读取数据用区间内最大的接[SuperClass，Object)

        //写入
        //list1.add(new SuperClass(" "));报错，写入只能用区间内最小的类型，负无穷没有明确的最小的类型
        list2.add(new SuperClass("略略略"));
        list2.add(new SubClass("略略略"));
    }

    public static void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

//泛型类
class GenericClass<T>{
    private int age;
    private String name;
    private T objectT;

    public GenericClass() {
    }

    public GenericClass(int age, String name, T objectT) {
        this.age = age;
        this.name = name;
        this.objectT = objectT;
    }

    public T getObjectT(){
        return objectT;
    }

    public void setObjectT(T objectT){
        this.objectT = objectT;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", objectT=" + objectT +
                '}';
    }

    //泛型方法
    public <E> E showE(E e){
        System.out.println("showE:" + e.toString());
        return e;
    }
}

class SubGenericClass<T,V> extends GenericClass<T>{
    private V objectV;

    public SubGenericClass() {
    }

    public SubGenericClass(int age, String name, T objectT, V objectV) {
        super(age, name, objectT);
        this.objectV = objectV;
    }

    public V getObjectV() {
        return objectV;
    }

    public void setObjectV(V objectV) {
        this.objectV = objectV;
    }

    @Override
    public String toString() {
        return "SubGenericClass{" +
                "objectV=" + objectV +
                '}';
    }
}
