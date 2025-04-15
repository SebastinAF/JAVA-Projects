package shapesUsingJDBC;

import java.util.Scanner;

public abstract class Shape {

    protected Scanner in = new Scanner(System.in);

    protected String shapeType;
    protected String shapeID;
    protected double surfaceArea;

    String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding-utf8";
    String username = "root";
    String password = "root";

    abstract public void getInput();
    abstract public void calculateArea();
    abstract public void AddToDatabase();

    public Shape(){
        shapeID = "undefined";
    }

    public Shape(String shapeID, String shapeType){
        this.shapeType = shapeType;
        this.shapeID = shapeID;
    }

}
