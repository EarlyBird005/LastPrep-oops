/*
class UnsynchronizedSum {
  private static Integer sum = 0;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      new Thread(() -> sum = sum + 1).start();
    }
    Thread.sleep(1000);

    System.out.println("Final sum (without synchronization): " + sum);
  }
}

class SynchronizedSum {
  private static Integer sum = 0;
  private static final Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        synchronized (lock) {
          sum = sum + 1;
        }
      }).start();
    }
    Thread.sleep(1000);

    System.out.println("Final sum (with synchronization): " + sum);
  }
}

*/