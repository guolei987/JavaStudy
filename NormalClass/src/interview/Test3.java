package interview;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class Test3 {
    private static Test3 instance = null;

    private Test3() {
    }

    public static Test3 getInstance() {
        if (instance == null) {
            synchronized (Test3.class) {
                if (instance == null) {
                    instance =  new Test3();
                }
            }
        }
        return instance;
    }
}
