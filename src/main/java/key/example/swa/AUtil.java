package key.example.swa;

public class AUtil {

  /*@ normal_behaviour
    @ requires array != null;
    @ requires i1 >= 0 && i1 < array.length && i2 >= 0 && i2 < array.length;
    @ ensures array[i2] == \old(array[i1]);
    @ ensures array[i1] == \old(array[i2]);
    @ assignable array[i1], array[i2];
    @*/
  public static void swap(int[] array, int i1, int i2) {
    int t = array[i1];
    array[i1] = array[i2];
    array[i2] = t;
  }
}
