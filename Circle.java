public class Circle extends Shape {
    String radius;

    public Circle(String color, String xPos, String yPos, String radius) {
        super(color, xPos, yPos);
        this.radius = radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + ", xPos=" + xPos + ", yPos=" + yPos + ", radius=" + radius + "]";
    }
}
