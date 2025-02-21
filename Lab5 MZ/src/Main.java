public class Main {
    public static void main(String[] args) {
        ArrayProcessor.initializeArray();

        Thread thread1 = new Thread(() -> {
            ArrayProcessor.processArray(value -> value - 1, "Thread 1");
        });

        Thread thread2 = new Thread(() -> {
            ArrayProcessor.processArray(value -> value * 3, "Thread 2");
        });

        Thread thread3 = new Thread(() -> {
            ArrayProcessor.processArray(value -> value + 3, "Thread 3");
        });

        try {
            thread1.start();
            thread1.join(); // Чекаємо, поки потік 1 завершиться

            thread2.start();
            thread2.join(); // Чекаємо, поки потік 2 завершиться

            thread3.start();
            thread3.join(); // Чекаємо, поки потік 3 завершиться
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final array:");
        ArrayProcessor.printArray();
    }
}
