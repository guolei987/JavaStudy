package package1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class SocketExampleTest2 {
    @Test
    public void test1() {
        Socket so = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            so = new Socket(inet, 9988);
            os = so.getOutputStream();
            File file = new File("beauty.jpg");
            fis = new FileInputStream(file);
            int len;
            byte[] cbuf = new byte[1024];
            while ((len = fis.read(cbuf)) != -1) {
                os.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (so != null) {
                try {
                    so.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() {
        ServerSocket ss = null;
        Socket so = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(9988);
            so = ss.accept();
            is = so.getInputStream();
            File file = new File("beauty1.jpg");
            fos = new FileOutputStream(file);
            int len;
            byte[] cbuf = new byte[1024];
            while ((len = is.read(cbuf)) != -1) {
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (so != null) {
                try {
                    so.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
