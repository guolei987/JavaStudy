package package2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @auther guolei
 * @create 2022年-3月-15日 晚上7点11分
 */
public class ReflectTest {
    @Test
    public void test1() throws Exception{
        Properties properties = new Properties();
        //方式1  文件流方式中默认路径是module下
        //FileInputStream fis = new FileInputStream("src\\jdbc.properties");
        //方式2  类加载器默认路径是src下
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println("name=" + name + ",age=" + age);
        //fis.close();
        assert is != null;
        is.close();
    }
}
