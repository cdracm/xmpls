package key.example;

class K {

  /*@ 
    @ requires n >= 0;
    @ ensures  \result == n;
    @*/
  static int su(int n) {
    int r = 0;
  /*@
    @ loop_invariant i>=0 && i <= n;
    @ loop_invariant r == i;
    @ decreases n-i;
    @*/
    for (int i = 0; i != n; i++) r = r+1;
    return r;
  }

}