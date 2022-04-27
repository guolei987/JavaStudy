package package1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther guolei
 * @create sada-sdaa-dasdad dad
 */
public class SocketExampleTest1 {
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inet = InetAddress.getByName("localhost");
            socket = new Socket(inet,8899);
            outputStream = socket.getOutputStream();
            outputStream.write(("来自客户端" + socket.getInetAddress() + "的请求").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        ServerSocket ss = null;
        Socket so = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            so = ss.accept();
            is = so.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] cbuf = new byte[5];
            int len;
            while((len = is.read(cbuf)) != -1){
                baos.write(cbuf,0,len);
            }
            System.out.println(baos.toString());
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(so != null){
                try {
                    so.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
