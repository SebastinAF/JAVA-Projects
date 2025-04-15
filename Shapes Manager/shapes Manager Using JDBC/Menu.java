package shapesUsingJDBC;

import java.util.Scanner;

public class Menu {

    Scanner in =new Scanner(System.in);
    ShapesManager sm = new ShapesManager();

    private void displayHeader(){
        System.out.println("\n\t SHAPES MANAGER PROJECT ");
    }

    public void displayMainManu(){
        int sel = 0;
        while (sel != 9){
            displayHeader();
            System.out.println(" MAIN MENU");
            System.out.println("1. Add Shapes");
            System.out.println("2. List Shapes");
            System.out.println("3. Delete Shapes");
            System.out.println("9. Exit");
            System.out.println("\n Enter your choice : ");
            sel = in.nextInt();

            switch (sel){
                case 1:
                    //Adda Shapes
                    displayShapesManu();
                    break;
                case 2:
                    //List Shapes
                    sm.displayDatabase();
                    break;
                case 3:
                    //Delete Shapes
                    sm.deleteData();
                    break;
                case 9:
                    //exit
                    break;

                default:
                    System.out.println("\t!!Invalid choice, Try Again..");

            }
        }
    }

    private void displayShapesManu(){
        int sel = 0;
        while (sel != 9){
            displayHeader();
            System.out.println("\t SHAPES MENU");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Circle");
            System.out.println("4. Cube");
            System.out.println("9. Exit");
            System.out.println("\n Enter your choice : ");
            sel = in.nextInt();

            switch (sel){
                case 1:
                      sm.AddShapes(ShapesManager.shapeType.Square);
                    break;
                case 2:
                      sm.AddShapes(ShapesManager.shapeType.Rectangle);
                    break;
                case 3:
                    sm.AddShapes(ShapesManager.shapeType.Circle);
                    break;
                case 4:
                    sm.AddShapes(ShapesManager.shapeType.Cube);
                    break;
                case 9:
                    //exit
                    break;

                default:
                    System.out.println("\t!!Invalid choice, Try Again..");

            }
        }
    }
}
