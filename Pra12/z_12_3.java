public class z_12_3 {
    private static Integer sum = 0;
    private static Integer synSum = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    sum++;
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("without synchronization: " + sum);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    synchronized (lock) {
                        synSum++;
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("with synchronization: " + synSum);
    }
}