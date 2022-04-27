package package1;

import org.junit.Test;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class EnumTest {
    @Test
    public void test1(){
        NormalEnum spring = NormalEnum.SPRING;
        System.out.println(spring.getName()+spring.getDesc());
    }

    @Test
    public void test2(){
        RealEnum summer = RealEnum.SUMMER;
        System.out.println(RealEnum.class.getSuperclass());
        System.out.println(summer);
        System.out.println("************************");
        RealEnum[] values = RealEnum.values();
        for (RealEnum value : values) {
            System.out.print(value.getName());
            value.show();
        }
    }
}
class NormalEnum{
    private String name;
    private String desc;

    private NormalEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static final NormalEnum SPRING;
    public static final NormalEnum SUMMER;
    public static final NormalEnum AUTUMN;
    public static final NormalEnum WINTER;

    static {
        SPRING = new NormalEnum("春天","春暖花开");
        SUMMER = new NormalEnum("夏天","夏日炎炎");
        AUTUMN = new NormalEnum("秋天","秋高气爽");
        WINTER = new NormalEnum("冬天","冰天雪地");
    }
}
enum RealEnum implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天夏天悄悄过去留下小秘密");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private String name;
    private String desc;

    private RealEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
interface Info{
    void show();
}