package package1;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @auther guolei
 * @create 2022-3-10 18:56
 */
public class IOTest {
    @Test
    public void test1(){
        File file = new File("hello.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("文件相关信息");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

        System.out.println("IO相关");
        System.out.println("read().......");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int read;
            while((read = fileReader.read()) != -1){
                //System.out.print(read + " ");
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        FileReader fr = null;
        try {
            File file = new File("Dog.jpg");
            fr = new FileReader(file);

            System.out.println("read(char[] c).......");

            char[] c = new char[6];
            int len;
            while ((len = fr.read(c))!= -1){
                String str = new String(c,0,len);
                System.out.println(str);
            }

            System.out.println("文件的长度为:" + file.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello1.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            int len;
            char[] c = new char[5];
            while((len = fr.read(c)) != -1){
                fw.write(c,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        FileInputStream fis = null;
        try {
            File file = new File("Dog.jpg");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用缓冲字节流实现文件复制
     */
    @Test
    public void test5(){
        long begin = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File src = new File("Dog.jpg");
            File dest = new File("Dog1.jpg");
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] cbuf = new byte[10];
            int len;
            while((len = bis.read(cbuf)) != -1){
                bos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - begin) + "ms");
    }
}
