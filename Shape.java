import java.util.ArrayList;

public abstract class Shape {
    String color;
    String xPos;
    String yPos;
    ArrayList<String> previousColors;
    ArrayList<String> previousXPos;
    ArrayList<String> previousYPos;

    public Shape(String color, String xPos, String yPos) {
        this.color = color;
        this.xPos = xPos;
        this.yPos = yPos;
        this.previousColors = new ArrayList<String>();
        this.previousXPos = new ArrayList<String>();
        this.previousYPos = new ArrayList<String>();
    }

    public void setPos(String xPos, String yPos) {
        this.previousXPos.add(this.xPos);
        this.previousYPos.add(this.yPos);
        this.xPos = xPos;
        this.yPos = yPos;
    }   

    public void setColor(String color) {
        this.previousColors.add(this.color);
        this.color = color;
    }

    public void undoColor() {
        if (this.previousColors.size() > 0) {
            this.color = this.previousColors.get(this.previousColors.size() - 1);
            this.previousColors.remove(this.previousColors.size() - 1);
        }
        else {
            System.out.println("Can't undo. No previous colors.");
        }
    }

    public void undoPos() {
        if (this.previousXPos.size() > 0 && this.previousYPos.size() > 0) {
            this.xPos = this.previousXPos.get(this.previousXPos.size() - 1);
            this.yPos = this.previousYPos.get(this.previousYPos.size() - 1);
            this.previousXPos.remove(this.previousXPos.size() - 1);
            this.previousYPos.remove(this.previousYPos.size() - 1);
        }
        else {
            System.out.println("Can't undo. No previous positions.");
        }
    }

    public abstract String toString();
}
