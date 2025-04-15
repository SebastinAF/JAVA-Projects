package shapes;

import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    ShapesManager sm = new ShapesManager();

    private void displayHeader() {
        System.out.println("SHAPES MANAGER PROJECT");
    }

    public void displayMainMenu(){
        int sel = 0; // sel means selection
        while(sel != 9) {
            displayHeader();
            System.out.println("Main Menu");
            System.out.println();
            System.out.println("1. Add a shapes");
            System.out.println("2. Delete a shapes");
            System.out.println("3. List Shapes");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");
            sel = in.nextInt();

            switch (sel) {
                case 1:
                    // Add Shape
                    displayShapesMenu();
                    break;
                case 2:
                    // Delete Shape
                    sm.deleteShape();
                    break;
                case 3:
                    // List Shapes
                    sm.ListShapes();
                    break;
                case 9:
                    // Exit
                    break;
                default:
                    System.out.println("Invalid selection. Try again!!!");
                    break;
            }
        }
    }

    private void displayShapesMenu(){
        int sel = 0; // sel means selection
        while(sel != 9) {
            // displayHeader();
            System.out.println("Shapes Menu");
            System.out.println();
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Cube");
            System.out.println("4. Circle");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");
            sel = in.nextInt();

            switch (sel) {
                case 1:
                    // Add Square
                    sm.AddShape(ShapesManager.shapeTypes.Square);
                    break;
                case 2:
                    // Add Rectangle
                    sm.AddShape(ShapesManager.shapeTypes.Rectangle);
                    break;
                case 3:
                    // Add Cube
                    sm.AddShape(ShapesManager.shapeTypes.Cube);
                    break;
                case 4:
                    // Add Circle
                    sm.AddShape(ShapesManager.shapeTypes.Circle);
                    break;
                case 9:
                    // Exit
                    break;
                default:
                    System.out.println("Invalid selection. Try again!!!");
                    break;
            }
        }
    }
}
