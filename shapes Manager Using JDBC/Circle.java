package shapesUsingJDBC;

import java.sql.*;

public class Circle extends  Shape{

    double radius;

    public Circle(){
        shapeType = "Circle";
    }

    @Override
    public void getInput() {
//        getShapeID();
        System.out.println("Enter the Radius : ");
        radius = in.nextDouble();
        calculateArea();
    }

    public void calculateArea(){
        surfaceArea = (22/7.0)*radius;
    }

    public void AddToDatabase(){

        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement ;
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("INSERT INTO jdbc.shapesrecord (shape_type, sarface_area, radius) VALUES (?, ?, ?)");

            preparedStatement.setString(1, shapeType);
            preparedStatement.setDouble(2, surfaceArea);
            preparedStatement.setDouble(3, radius);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();


            System.out.println("\n\t DATA ADDED SUCCESSFULLY\n\n");

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
