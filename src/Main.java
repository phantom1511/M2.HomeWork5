import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Бишкек -> Ош");
        try {
            Semaphore semaphore = new Semaphore(4);
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 1; i < 101; i++) {
                new Passenger(semaphore, countDownLatch, i).start();
            }

            countDownLatch.await();

            Thread.sleep(2000);
            System.out.println("Все пассажиры сели");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
