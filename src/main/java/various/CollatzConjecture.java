package various;

public class CollatzConjecture {
  public static void test(int n) {
    while (n != 1) {
      n = n % 2 == 0 ? n / 2 : 3 * n + 1;
    }
  }
  public static void main(String[] args) {
    for (int i = 0; ; i++) test(i);
  }
}
