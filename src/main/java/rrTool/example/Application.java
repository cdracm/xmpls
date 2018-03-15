package x;

public class Application implements Runnable {
  private int value;

  public /*synchronized*/ int getValue() {
    return value;
  }

  public /*synchronized*/ void setValue(final int value) {
    this.value = value;
  }

  public void run() {
    for (int i=0; i<1000; i++) {
      value++;
    }
  }

  public static void main(String[] args) throws Exception {
   Application d = new Application();
   Thread t1 = new Thread(d);   t1.start();
   Thread t2 = new Thread(d);   t2.start();
   t1.join();   t2.join();
   System.out.println("value = "+d.getValue());
  }

}
