package key.example.first;

public class First {

  /*@ normal_behaviour
    @ requires true;
    @ ensures array != null && array.length != 0 && \result == array[0] || \result == null;
    @ assignable \nothing;
    @*/
  public static Object getFirstElement(Object[] array) {
    return array == null || array.length == 0 ? null : array[0];
  }

}
