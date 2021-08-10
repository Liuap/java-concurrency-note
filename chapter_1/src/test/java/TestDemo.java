import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author pal
 * @date 2021/8/10 1:18 下午
 */

@SpringBootTest
public class TestDemo {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();


    @Test
    public void test(){
        threadLocal.set("");
        System.out.println("demo");
    }




    @Test
    public void threadLocalTest(){
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadOne local var");
                System.out.println("threadOne : "+threadLocal.get());
            }
        });

        Thread threadTwo = new Thread(() -> {
            threadLocal.set("threadTwo local var");
            System.out.println("threadTwo : "+threadLocal.get());
        });

        threadOne.start();
        threadTwo.start();
    }


}
