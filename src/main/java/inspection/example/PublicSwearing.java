package inspection.example;

import org.jetbrains.annotations.Nls;

public class PublicSwearing {
  void showError() {
    messageBox("You fu*(* moron!");
  }

  private void messageBox(@Nls String msg) {
    //
  }
}
