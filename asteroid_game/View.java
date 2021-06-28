import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  public App app;
  public DisplayPanel display;

  public View(App app) {
    this.app = app;
    display = new DisplayPanel(this);
    addKeyListener(app.controller.new ControllerKeyAdapter());
    add(display);
    pack();
    setTitle("Astroids Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("hi");
  }

}
