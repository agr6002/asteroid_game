import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {

  Model model;
  RenderingHints renderingHints;
  View view;

  private static final long serialVersionUID = 1L;

  public DisplayPanel(View view) {
    this.view = view;
    model = this.view.app.model;
    renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    setPreferredSize(new Dimension(800, 600));
    setBackground(Color.BLACK);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(renderingHints);
    g2d.setStroke(new BasicStroke(1));
    g2d.setColor(Color.WHITE);
    model.player.draw(g2d);
    for (int i = 0; i < 8; ++i) {
      model.asteroids[i].draw(g2d);
    }
    Toolkit.getDefaultToolkit().sync();
  }

  public void update() {
    repaint();
  }

}
