package shapes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapesManager {
    public enum shapeTypes {Square, Rectangle, Cube, Circle};
    String shapesFileName = "D:\\MCA\\java Add On\\Java Notes 2\\Shapes Manager\\src\\shapes\\shapes.txt";
    ArrayList<Shape> shapes = new ArrayList<>();

    // Add Shapes.
    public boolean AddShape(shapeTypes type) {
        Shape s = null;
        switch (type) {
            case Square:
                s = new Square();
                break;
            case Rectangle:
                s = new Rectangle();
                break;
            case Cube:
                s = new Cube();
                break;
            case Circle:
                s = new Circle();
                break;
        }
        s.getInput();
        // System.out.println(s.toCSVString());
        // s.deserialize(s.toCSVString());
        shapes.add(s);
        // This calls toString() of the shape
        // System.out.println(shapes);
        AddShape2File(s);
        s = null;
        return true;
    }

    // Add shapes.Shape to the File.
    private void AddShape2File(Shape s) {
        FileWriter f = null;
        try {
            f = new FileWriter(shapesFileName, true);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(s.toCSVString());
            bw.newLine();
            bw.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            f = null;
        }
    }

    public void ListShapes() {
        // System.out.println("List of Shapes");
		/*
		for(shapes.Shape s: shapes) {
			System.out.println(s.toString());
		} */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(shapesFileName));
            String line;
            System.out.println("List of Shapes from File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void deleteShape() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ID for DELETE");
        String id = in.nextLine();
        getShape(id);
    }

    public void getShape(String id) {

        File inputFile = new File(shapesFileName);
        File tempFile = new File("temp.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[1].trim().equals(id)) {
                    found = true;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Matching record found:");
                    System.out.println(line);
                    System.out.print("Do you want to delete this record? (yes/no): ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        System.out.println(" Record deleted.");
                        continue; // Don't write this line to the temp file
                    } else {
                        System.out.println(" Deletion canceled. Record kept.");
                    }
                }
                writer.write(line);
                writer.newLine();
            }

            if (!found) {
                System.out.println(" No record found with ID: " + id);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Replace the old file with the new one
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file.");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file.");
        }

    }
}
