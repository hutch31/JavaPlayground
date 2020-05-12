package test1;

public class ConcurrencyFail {
  private static boolean ready;
  private static int value;

  private static class ReaderThread extends Thread {
    public void run() {
        while (!ready) 
          Thread.yield();
        System.out.println(value);
    }
  }

  public static void main(String[] args) {
     new ReaderThread().start();
     value = 42;
     ready = true;
  }
}