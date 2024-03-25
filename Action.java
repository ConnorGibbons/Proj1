import java.util.*;

public class Action {
    Shape targetShape;
    String action; // move, color, or create
    ArrayList<Shape> shapes;

    public Action(Shape targetShape, String action, ArrayList<Shape> shapes) {
        this.targetShape = targetShape;
        this.action = action;
        this.shapes = shapes;
    }

    public void undo() {
        if (this.action.equals("move")) {
            targetShape.undoPos();
        }
         else if (action.equals("color")) {
            targetShape.undoColor();
        }
        else if (action.equals("create")) {
            shapes.remove(targetShape);
        }
    }
}
