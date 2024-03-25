import java.util.ArrayList;
import java.util.Scanner;

public class DrawingApp {

    public static void undo(ArrayList<Action> actions) {
        if (actions.size() > 0) {
            actions.get(actions.size() - 1).undo();
            actions.remove(actions.size() - 1);
        }
        else {
            System.out.println("Can't undo. No previous actions.");
        }
    }

    public static void printArtboard(ArrayList<Shape> shapes) {
        if(shapes.size() == 0) {
            System.out.println("No shapes to print! use \"create\" to add a shape.");
            return;
        }
        for(Integer i = 0; i < shapes.size(); i++) {
            System.out.println(i.toString() + ": " + shapes.get(i));
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        ArrayList<Action> actions = new ArrayList<Action>();

        while(true) {
            System.out.println("Enter a command: print, create, move, color, undo, or exit.");
            String command = scanner.nextLine();
            if(command.equals("print")){
                printArtboard(shapes);
            }
            else if(command.equals("create")){
                System.out.println("Enter the shape type: square or circle");
                String shapeType = scanner.nextLine();
                System.out.println("Enter the color, x position, and y position separated by spaces.");
                String[] shapeInfo = scanner.nextLine().split(" ");
                if(shapeType.equals("square")) {
                    System.out.println("Enter the side length.");
                    String side = scanner.nextLine();
                    Square square = new Square(shapeInfo[0], shapeInfo[1], shapeInfo[2], side);
                    shapes.add(square);
                    actions.add(new Action(square, "create", shapes));
                }
                else if(shapeType.equals("circle")) {
                    System.out.println("Enter the radius.");
                    String radius = scanner.nextLine();
                    Circle circle = new Circle(shapeInfo[0], shapeInfo[1], shapeInfo[2], radius);
                    shapes.add(circle);
                    actions.add(new Action(circle, "create", shapes));
                }
                else {
                    System.out.println("Invalid shape type.");
                }
            }
            else if(command.equals("move")) {
                System.out.println("Enter the index of the shape to move.");
                Integer index = Integer.parseInt(scanner.nextLine());
                if(index >= shapes.size() || index < 0) {
                    System.out.println("Invalid index.");
                    continue;
                }
                System.out.println("Enter the new x and y positions separated by spaces.");
                String[] newPos = scanner.nextLine().split(" ");
                Shape targetShape = shapes.get(index);
                targetShape.setPos(newPos[0], newPos[1]);
                actions.add(new Action(targetShape, "move", shapes));
            }
            else if(command.equals("color")) {
                System.out.println("Enter the index of the shape to color.");
                Integer index = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the new color.");
                String newColor = scanner.nextLine();
                Shape targetShape = shapes.get(index);
                targetShape.setColor(newColor);
                actions.add(new Action(targetShape, "color", shapes));
            }
            else if(command.equals("undo")) {
                undo(actions);
            }
            else if(command.equals("exit")) {
                break;
            }
            else {
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
        System.out.println("Final result: ");
        printArtboard(shapes);
    }
}
