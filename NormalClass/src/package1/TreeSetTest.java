package package1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @auther guolei
 * @create 11-11-11 11
 */
public class TreeSetTest {
    @Test
    public void test1(){
//        ArrayList<Integer> arr = new ArrayList<>();
//        Map<Integer,Integer> map = new HashMap<>();
//        Collection<Integer> values = map.values();
//        arr.addAll(values);

        TreeSet set = new TreeSet();

        Employee e1 = new Employee("liudehua刘德华",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou张学友",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng郭富城",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming黎明",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei梁朝伟",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}

class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("输入的数据不对");
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
