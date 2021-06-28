import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

public class App {

  private final int INITIAL_DELAY = 100;
  private final int PERIOD_INTERVAL = 5;

  public Controller controller;
  public Model model;
  public View view;
  private Timer timer;

  public App() {
    controller = new Controller(this);
    model = new Model(this);
    view = new View(this);
    timer = new Timer();
    timer.scheduleAtFixedRate(new Task(), INITIAL_DELAY, PERIOD_INTERVAL);
  }

  public static void make() {
    EventQueue.invokeLater(() -> {
      new App();
    });
  }

  private class Task extends TimerTask {

    @Override
    public void run() {
      model.update(PERIOD_INTERVAL);
      view.display.update();
    }

  }

}