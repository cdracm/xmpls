package various;

public class H {
  static native boolean halts(String path);

  static void blowYourMind(String path) {
    if (halts(path)) {
      while (true);
    }
  }

  public static void main(String[] args) {
    blowYourMind("H.java:blowYourMind");
  }
}
