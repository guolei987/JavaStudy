package package1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @auther guolei
 * @create 1f-发-阿斯弗 阿松大
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("NormalClass\\Dog.jpg");
        File destFile = new File("NormalClass\\Dog2.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
