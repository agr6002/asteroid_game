import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;

public class Player {

  final double MIN_POS_X = 0.0;
  final double MAX_POS_X = 800.0;
  final double MIN_POS_Y = 0.0;
  final double MAX_POS_Y = 600.0;

  private double radius;
  private int numVertices;
  private Point2D.Double pos;
  private Point2D.Double[] vertices = {new Point2D.Double(25, 0), new Point2D.Double(-25, 12.5), new Point2D.Double(-12.5, 0), new Point2D.Double(-25, -12.5)};
  private Point2D.Double vel;
  private double rotateBy;
  private double moveBy;
  private double angle;
  private double spin;

  public Player() {
    angle = 0;
    rotateBy = 0.25;
    moveBy = 0.5;
    spin = 0;
    pos = new Point2D.Double(MAX_POS_X /2,  MAX_POS_Y/2);
    vel = new Point2D.Double(0, 0);
    numVertices = vertices.length;
    radius = getRadius(vertices);
  }

  private double getRadius(Point2D.Double[] vertices) {
      return 0; // change return
  }

  public void draw(Graphics2D g2d) {
    GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, numVertices);
    path.moveTo(vertices[0].x, vertices[0].y);
    for (int i = 1; i < numVertices; ++i) {
      path.lineTo(vertices[i].x, vertices[i].y);
    }
    path.closePath();
    AffineTransform transform = AffineTransform.getTranslateInstance(pos.x, pos.y);
    transform.rotate(angle);
    g2d.draw(transform.createTransformedShape(path));
  }

  public void updateModel(long timeChange) {
    // angle += spin;
    // pos.x += vel.x;
    // pos.y += vel.y;

    if (pos.x < -radius) {
      pos.x = 800 + radius;
    } else if (pos.x > 800 + radius) {
      pos.x = -radius;
    }
    if (pos.y < -radius) {
      pos.y = 600 + radius;
    } else if (pos.y > 600 + radius) {
      pos.y = -radius;
    }
  }

  public void rotate(boolean isDirectionLeft) {
    if (isDirectionLeft == true) {
      if (angle == 0) {
        angle = 6.25;
      }
      angle -= rotateBy;
    } else if (isDirectionLeft == false) {
      angle += rotateBy;
    }
    if (angle ==  6.25) {
      angle = 0;
    }
  }

  public void forward() {
    System.out.println(angle);
    pos.x += angle / 4.75 * moveBy;
    pos.y += angle / 4.75 * moveBy;
  }
}
