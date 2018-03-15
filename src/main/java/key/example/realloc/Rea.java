package key.example.realloc;

public class Rea {

  /*@ normal_behaviour
    @ requires array != null && newSize >=0;
    @ ensures (\result != null && \result.length == newSize);
    @ ensures (\forall int j; 0 <= j && j < newSize && j < array.length; \result[j] == array[j]);
    @ ensures (\forall int j; j < newSize && j >= array.length; \result[j] == 0);
    @ assignable \nothing;
    @*/
  public static int[] realloc(int[] array, int newSize) {
    if (newSize == 0) {
      return new int[0];
    }
    else {
      int oldSize = array.length;
      if (oldSize == newSize) {
        return array;
      }
      else {
        int[] result = new int[newSize];
        int n = oldSize <= newSize ? oldSize : newSize;
        copy(array, result, n);
        return result;
      }
    }
  }

  /*@ normal_behaviour
    @ requires array != null && n >=0 && n <= array.length && n <= result.length;
    @ ensures (\forall int j; 0 <= j && j < n; result[j] == array[j]);
    @ assignable result[0..n-1];
    @*/
  private static void copy(int[] array, int[] result, int n) {
  /*@
    @ loop_invariant i>=0 && i <= n;
    @ loop_invariant (\forall int j; 0<=j && j < i; result[j] == array[j]);
    @ decreasing n-i;
    @ assignable result[0..n-1];
    @*/
    for (int i = 0; i< n; i++) {
      result[i] = array[i];
    }
  }
}
