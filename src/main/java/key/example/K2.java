package key.example;

class K2 {

  /*@ 
    @ requires n >= 0;
    @ ensures  \result == n * (n+1)/2;
    @*/
  static int su(int n) {
    int r = 0;
  /*@
    @ loop_invariant i>=0 && i <= n;
    @ loop_invariant r == i * (i+1)/2;
    @ decreases n-i;
    @*/
    for (int i = 0; i != n; i++) r += i;
    return r;
  }

}