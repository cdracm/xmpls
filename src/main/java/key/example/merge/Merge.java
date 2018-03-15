package key.example.merge;

public class Merge {
  /*@ normal_behaviour
    @ requires a1 != null && a2 != null;
    @ ensures (\result != null && \result.length == a1.length + a2.length);
    @ ensures (\forall int j; 0 <= j && j < a1.length; \result[j] == a1[j]);
    @ ensures (\forall int j; a1.length <= j && j < a1.length + a2.length; \result[j] == a2[j-a1.length]);
    @ assignable \nothing;
    @*/
  public static int[] mergeArrays(int[] a1, int[] a2) {
    if (a1.length == 0) {
      return a2;
    }
    else if (a2.length == 0) {
      return a1;
    }
    else {
      int[] result = new int[a1.length + a2.length];
      copy(a1, result, 0, a1.length);
      copy(a2, result, a1.length, a2.length);

      return result;
    }
  }

  /*@ normal_behaviour
    @ requires array != null && n >=0 && n <= array.length && n <= result.length;
    @ requires array != result;
    @ requires out >= 0 && out <= result.length - n;
    @ ensures (\forall int j; 0 <= j && j < n; result[j+out] == array[j]);
    @ assignable result[out..out+n-1];
    @*/
  private static void copy(int[] array, int[] result, int out, int n) {
  /*@
    @ loop_invariant i>=0 && i <= n;
    @ loop_invariant (\forall int j; 0 <= j && j < i; result[j+out] == array[j]);
    @ decreasing n-i;
    @ assignable result[out..out+n-1];
    @*/
    for (int i = 0; i< n; i++) {
      result[i+out] = array[i];
    }
  }

}
