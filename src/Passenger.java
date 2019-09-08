import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int id;

    public Passenger(Semaphore semaphore, CountDownLatch countDownLatch, int id) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    public void run(){

        try {
            semaphore.acquire();
            System.out.println("Пассажир " + id + " покупает билет");
            sleep(2000);

            System.out.println("Пассажир " + id + " содится в автобус");
            semaphore.release();
            sleep(2000);

            countDownLatch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
