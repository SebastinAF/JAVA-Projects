package shapesUsingJDBC;

import java.sql.*;

public class Square extends Shape {

    double side;

    public Square() {
         shapeType = "Square";
    }

    public Square(String shapeType, String shapeID){
        super(shapeType, shapeID);
    }

    @Override
    public void getInput() {
//        getShapeID();
        System.out.println("Enter the side of Square : ");
        side = in.nextDouble();
        calculateArea();
    }

    public void calculateArea(){
        surfaceArea = side * side;
    }

    public void AddToDatabase(){

        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement ;
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("INSERT INTO jdbc.shapesrecord (shape_type, sarface_area, side) VALUES (?, ?, ?)");

            preparedStatement.setString(1, shapeType);
            preparedStatement.setDouble(2, surfaceArea);
            preparedStatement.setDouble(3, side);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();


            System.out.println("\n\t DATA ADDED SUCCESSFULLY\n\n");

        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
