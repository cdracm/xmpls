package key.example.m;

class Ma {

  /*@ 
    @ requires a >= 0;
    @ requires b >= 0;
    @ ensures  \result >= a && \result >= b && (\result == a || \result == b);
    @*/
  static int m(int a, int b) {
    if (a < b) return b;
    else return a;
  }

}