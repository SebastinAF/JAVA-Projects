package shapes;

public class ShapesMain {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMainMenu();
        menu = null; // Destroy the Object
        System.out.println("Thanks for your choice. Program ends here.");
    }
}