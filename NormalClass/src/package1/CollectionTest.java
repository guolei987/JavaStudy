package package1;

import org.junit.Test;

import java.util.*;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(true);
        coll.add("哈哈哈");
        coll.add(new Date());
        coll.add(new Person("张三","法外狂徒"));

        //1.contains  遍历集合 一个一个地比 如果提前找到了匹配就不再往后遍历
        System.out.println("-----contains()-----");
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("哈哈哈")));
        //自定义类必须要重写equals方法，因为contains方法会调用它进行判断。
        System.out.println(coll.contains(new Person("张三","法外狂徒")));

        //2.containsAll 只有包含形参集合中的所有元素才返回true
        System.out.println("-----containsAll()-----");
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new Person("张三","法外狂徒"));
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(true);
        coll.add("哈哈哈");
        coll.add(new Date());
        coll.add(new Person("张三","法外狂徒"));

        //3.remove 删除成功返回true 反则返回false
        System.out.println("-----remove()-----");
        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Date());
        System.out.println(coll);
        coll.remove(new Person("张三","法外狂徒"));
        System.out.println(coll);

        //4.removeAll 留下调用集合和形参集合的差集
        System.out.println("-----removeAll()-----");
        Collection coll1 = Arrays.asList(345,456);
        coll.removeAll(coll1);
        System.out.println(coll);

        //5.retainAll 留下调用集合和形参集合的交集并返回给调用集合
        System.out.println("-----retainAll()-----");
        Collection coll2 = new ArrayList();
        coll2.add(true);
        coll2.add(new String("哈哈哈"));
        coll.retainAll(coll2);
        System.out.println(coll);

        //6.equals 比较两个集合是否相等 看对应位置的元素是不是都相等，位置不同都不行(对于List)
        System.out.println("-----equals()-----");
        Collection coll3 = new ArrayList();
        coll3.add(123);
        coll3.add("aa");
        coll3.add(new Person("李四","背信弃义"));
        Collection coll4 = new ArrayList();
        coll4.add(123);
        coll4.add("aa");
        coll4.add(new Person("李四","背信弃义"));
        Collection coll5 = new ArrayList();
        coll5.add(new Person("李四","背信弃义"));
        coll5.add(123);
        coll5.add("aa");
        System.out.println("coll3 == coll4 ? :" + coll3.equals(coll4));
        System.out.println("coll3 == coll5 ? :" + coll3.equals(coll5));
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(true);
        coll.add("哈哈哈");
        coll.add(new Date());
        coll.add(new Person("张三","法外狂徒"));

        //7.hashcode哈希码
        System.out.println("-----hashcode()-----");
        System.out.println(coll.hashCode());

        //8.toArray  集合转数组
        System.out.println("-----toArray()-----");
        Object[] objects = coll.toArray();
        for(int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }

        //9.asList  数组转集合 该方法是可变形参 相当于传个数组筋去
        System.out.println("-----asList()-----");
        List list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
        List list1 = Arrays.asList(new int[]{1, 2, 3});//注意整型的数组扔进去会把数组整体当成一个参数
        System.out.println(list1);
        List list2 = Arrays.asList(1, 2, 3);//这样写才对
        System.out.println(list2);
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(true);
        coll.add("哈哈哈");
        coll.add(new Date());
        coll.add(new Person("张三","法外狂徒"));

        //9.iterator迭代器遍历集合 搭配hasNext()和next() hasNext()判断是否还有下一个元素。next()①指针下移②将下移以后集合位置上的元素返回
        Iterator iterator = coll.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
            //iterator还有一个remove方法用来删除元素。删除指针指着的那个元素。
        }
    }

}
class Person{
    private String name;
    private String desc;

    public Person() {
    }

    public Person(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String age) {
        this.desc = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals......");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return desc != null ? desc.equals(person.desc) : person.desc == null;
    }

//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (desc != null ? desc.hashCode() : 0);
//        return result;
//    }
}