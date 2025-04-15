package shapesUsingJDBC;

import java.sql.*;

public class Cube extends Shape {

    double length, breadth, height;

    public Cube(){
        shapeType = "Cube";
    }

    @Override
    public void getInput() {
//        getShapeID();
        System.out.println("Enter the Length  : ");
        length = in.nextDouble();
        System.out.println("Enter the Breadth : ");
        breadth = in.nextDouble();
        System.out.println("Enter the Height : ");
        height = in.nextDouble();
        calculateArea();
    }

    public void calculateArea(){
        surfaceArea = 2 * (length * breadth + breadth * height + height * length);
    }

    public void AddToDatabase(){

        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement ;
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("INSERT INTO jdbc.shapesrecord (shape_type, sarface_area, length, breadth, height) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, shapeType);
            preparedStatement.setDouble(2, surfaceArea);
            preparedStatement.setDouble(3, length);
            preparedStatement.setDouble(4, breadth);
            preparedStatement.setDouble(5, height);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();


            System.out.println("\n\t DATA ADDED SUCCESSFULLY\n\n");

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
