import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Controller {
    private App app;

    public Controller(App app) {
        this.app = app;
    }
	public class ControllerKeyAdapter extends KeyAdapter {
        private boolean isPressed = false;
        @Override
        public void keyReleased(KeyEvent e) {
            switch ( e.getKeyCode() ) {
            case KeyEvent.VK_LEFT:
                    break;
            case KeyEvent.VK_RIGHT:
                    break;
            case KeyEvent.VK_UP:
                isPressed = false;
                break;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch ( e.getKeyCode() ) {
                case KeyEvent.VK_LEFT:
                    app.model.player.rotate(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    app.model.player.rotate(false);
                    break;
                case KeyEvent.VK_UP:
                    app.model.player.forward();
                    break;
            }
        }
    }
}
