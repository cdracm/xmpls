package ssr.example;

public class SSR {
  volatile String cachedName;
  
  String getName() {
    String result = cachedName;
    if (result == null) {
      cachedName = result = compute();
    }
    
    return result;
  }

  private String compute() {
    return null;
  }

  public static void main(String[] args) {
    SSR ssr = new SSR();
    ssr.cachedName = "";
    for (int i=0; i<1000; i++) {
      ssr.getName().hashCode();
    }
//    ssr.compute();
  }
}
