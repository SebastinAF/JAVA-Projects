package shapesUsingJDBC;

import java.sql.*;

public class Rectangle extends Shape{

    double length, breadth;

    public Rectangle(){
        shapeType = "Rectangle";
    }

    public Rectangle(String shapeType, String shapeID){
        super(shapeType, shapeID);
    }

    @Override
    public void getInput() {
        System.out.println("Enter the Length  : ");
        length = in.nextDouble();
        System.out.println("Enter the Breadth : ");
        breadth = in.nextDouble();
        calculateArea();
    }

    public void calculateArea(){
        surfaceArea = length * breadth;
    }

    public void AddToDatabase(){

        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement ;
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("INSERT INTO jdbc.shapesrecord (shape_type, sarface_area, length, breadth) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, shapeType);
            preparedStatement.setDouble(2, surfaceArea);
            preparedStatement.setDouble(3, length);
            preparedStatement.setDouble(4, breadth);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();


            System.out.println("\n\t DATA ADDED SUCCESSFULLY\n\n");

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
