package various;

public class ModelCheck {
  boolean workTime(int hour, int minute) {
    if (hour >= 20) return false;
    if (hour < 8) return false;
    if (hour == 14) { // обед
      return minute > 30;
    }
    return minute > 5; // зарядка каждый час
  }

}
