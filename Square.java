public class Square extends Shape {
    String length;

    public Square(String color, String xPos, String yPos, String length) {
        super(color, xPos, yPos);
        this.length = length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Square [color=" + color + ", xPos=" + xPos + ", yPos=" + yPos + ", side=" + length + "]";
    }
}