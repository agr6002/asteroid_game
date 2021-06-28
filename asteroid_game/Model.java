public class Model {

  private final int NUM_ASTEROIDS = 8;

  public App app;
  public Asteroid[] asteroids;
  public Player player;

  public Model(App app) {
    this.app = app;
    player = new Player();
    asteroids = new Asteroid[NUM_ASTEROIDS];
    for (int i = 0; i < NUM_ASTEROIDS; ++i) {
      asteroids[i] = new Asteroid();
    }
  }

  public void update(long timeChange) {
    player.updateModel(timeChange);
    for (int i = 0; i < NUM_ASTEROIDS; ++i) {
      asteroids[i].updateModel(timeChange);
    }
  }

}
