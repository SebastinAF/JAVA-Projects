package shapes;

import java.util.Scanner;

public abstract class Shape {
    protected Scanner in = new Scanner(System.in);

    protected String shapeType;
    protected String shapeID;
    protected double SurfaceArea;

    abstract public void getInput();
    abstract public void CalculateArea();
    abstract public String toCSVString();
    abstract public String toString();

    public Shape() {
        shapeID = "undefined";
    }

    public Shape(String shapeType, String shapeID) {
        this.shapeType = shapeType;
        this.shapeID = shapeID;
    }

    protected void getShapeID() {
        System.out.println("Enter Shape ID:");
        shapeID = in.nextLine();
    }

//    public void deserialize(String csv) {
//        String[] tokens;
//        tokens = csv.split(",");
//		/*
//		for(String t : tokens) {
//			System.out.println(t);
//		}*/
//        shapeType = tokens[0];
//        shapeID = tokens[1];
//        SurfaceArea =  Double.parseDouble(tokens[2]);
//        tokens = null;
//    }
}
