package key.example.add;

public class Util {

  /*@ normal_behaviour
    @ requires src != null;
    @ ensures  (\result != null && \result.length == src.length +1 && (\forall int j; 0 <= j && j < src.length; \result[j] == src[j]) && \result[src.length] == value);
    @ assignable \nothing;
    @*/
  public static int[] append(int[] src, int value) {
    int[] r = new int[src.length + 1];
    /*@
      @ loop_invariant i>=0 && i <= src.length;
      @ loop_invariant (\forall int j; 0<=j && j < i; src[j] == r[j]);
      @ decreasing src.length-i;
      @ assignable r[0..src.length-1];
      @*/
    for (int i = 0; i < src.length; i++) {
      r[i] = src[i];
    }
    r[src.length] = value;
    return r;
  }
}
