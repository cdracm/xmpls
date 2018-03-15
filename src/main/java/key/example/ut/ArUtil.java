package key.example.ut;

public class ArUtil {
  /*@ normal_behaviour
    @ requires src != null;
    @ ensures  (\result >= 0 && \result < src.length && src[\result] == obj) || \result ==-1 && (\forall int j; 0 <= j && j < src.length; src[j] != obj);
    @ assignable \nothing;
    @*/
  public static int find(int[] src, int obj) {
    int r = -1;
    /*@
      @ loop_invariant i>=0 && i <= src.length && src != null;
      @ loop_invariant (r >= 0 && r < src.length && src[r]==obj) || r==-1 && (\forall int j; 0<=j && j < i; src[j] != obj);
      @ decreasing src.length-i;
      @ assignable \nothing;
      @*/
    for (int i=0;i < src.length;i++) {
      if (src[i] == obj) {
        r = i;
        break;
      }
    }

    return r;
  }

  /*@ normal_behaviour
    @ requires src != null;
    @ ensures  (\result >= 0 && \result < src.length && src[\result] == obj) || \result ==-1 && (\forall int j; 0 <= j && j < src.length; src[j] != obj);
    @ assignable \nothing;
    @*/
  public static int find2(int[] src, int obj) {
    /*@
      @ loop_invariant i>=0 && i <= src.length && src != null;
      @ loop_invariant (\forall int j; 0<=j && j < i; src[j] != obj);
      @ decreasing src.length-i;
      @ assignable \nothing;
      @*/
    for (int i=0;i < src.length;i++) {
      if (src[i] == obj) {
        return i;
      }
    }

    return -1;
  }

}
