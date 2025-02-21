import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntUnaryOperator;

public class ArrayProcessor {
    private static int[] numbers = new int[100];
    private static final Lock lock = new ReentrantLock();

    public static void initializeArray() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
    }

    public static void processArray(IntUnaryOperator operator, String threadName) {
        System.out.println(threadName + " started.");

        lock.lock();
        try {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = operator.applyAsInt(numbers[i]);
            }
        } finally {
            lock.unlock();
        }

        System.out.println(threadName + " finished.");
        printArray();
    }

    public static void printArray() {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}