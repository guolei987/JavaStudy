package package2;

import org.junit.Test;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class ReflectTest2 {
    @Test
    public void test1() throws ClassNotFoundException {
        //得到Class实例的方式一 类.class属性
        Class clazz1 = String.class;
        //得到Class实例的方式二 对象.getClass()方法
        String str = new String("Hi");
        Class clazz2 = str.getClass();
        //得到Class实例的方式三 Class.forName()
        Class clazz3 = Class.forName("java.lang.String");

        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        Class<Boy> clazz = Boy.class;
        Boy boy = clazz.newInstance();
        System.out.println(boy);
    }
}
