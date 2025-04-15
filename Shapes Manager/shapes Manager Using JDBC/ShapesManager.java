package shapesUsingJDBC;

import java.sql.*;
import java.util.Scanner;

public class ShapesManager {

    public enum shapeType {Square, Rectangle, Circle, Cube};
    String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding-utf8";
    String username = "root";
    String password = "root";

    Scanner scanner = new Scanner(System.in);

    Shape s = null;

    public boolean AddShapes(shapeType type){

        switch (type){
            case Square :
                s = new Square();
                break;
            case Rectangle:
                s = new Rectangle();
                break;
            case Circle:
                s = new Circle();
                break;
            case Cube:
                s = new Cube();
                break;
        }
        s.getInput();
        s.AddToDatabase();
        return true;
    }

    public void displayDatabase(){

      try {

          Connection connection = DriverManager.getConnection(url,username,password);
          Statement statement = connection.createStatement();
          ResultSet resultSet;
          System.out.println(" Listing The Stored Records \n");

          String qry = "SELECT * FROM jdbc.shapesrecord";
          resultSet = statement.executeQuery(qry);

          if (resultSet.isBeforeFirst()) {

              while (resultSet.next()) {
                  int id = resultSet.getInt("shape_id");
                  String type = resultSet.getNString("shape_type");
                  double sa = resultSet.getDouble("sarface_area");
                  double si = resultSet.getDouble("side");
                  double len = resultSet.getDouble("length");
                  double bre = resultSet.getDouble("breadth");
                  double hei = resultSet.getDouble("height");
                  double ra = resultSet.getDouble("radius");

                  System.out.println("Shape ID : " + id + " ,   Shape Type : " + type + " ,  SurfaceArea : " + sa +
                          " ,  side : " + si + " ,  length : " + len +   ", breadth : " + bre + ",  Height : " + hei + ",  radius : " + ra);
              }
              resultSet.close();
              statement.close();
              System.out.println("\n\t  DETAILS LISTED\n\n");
          }
          else {
              resultSet.close();
              statement.close();
              System.out.println("\n\t  ! NO RECORD FOUND IN DATABASE\n\n");
          }
      } catch (SQLException e) {
          e.getMessage();
      }
    }

    public void deleteData(){

        System.out.println("\tDelete Operation\n");
        System.out.println("Enter Shape ID for Delete : ");
        int id = scanner.nextInt();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            String qry2 = "SELECT * FROM jdbc.shapesrecord where shape_id = ?";
            preparedStatement = connection.prepareStatement(qry2);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                scanner.nextLine();
                System.out.println("MATCH FOUND CONFIRM TO DELETE (Y/N)");

                int id2 = resultSet.getInt("shape_id");
                String type = resultSet.getNString("shape_type");
                double sa = resultSet.getDouble("sarface_area");
                double si = resultSet.getDouble("side");
                double len = resultSet.getDouble("length");
                double bre = resultSet.getDouble("breadth");
                double hei = resultSet.getDouble("height");
                double ra = resultSet.getDouble("radius");

                System.out.println("Shape ID : " + id2 + " ,   Shape Type : " + type + " ,  SurfaceArea : " + sa +
                        " ,  side : " + si + " ,  length : " + len +   ", breadth : " + bre + ",  Height : " + hei + ",  radius : " + ra);

                System.out.print("\nCONFIRM : ");
                String op = scanner.nextLine();

                if (op.equalsIgnoreCase("Y")) {
                   String qry = "DELETE FROM jdbc.shapesrecord WHERE shape_id = ? ";
                    preparedStatement = connection.prepareStatement(qry);

                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                    System.out.println("\n\t DELETED SUCCESSFULLY\n\n ");

                    preparedStatement.close();
                    connection.close();
                } else {
                    System.out.println("\n\t Delete Operation Cancelled \n\n");
                }
            } else {
                preparedStatement.close();
                connection.close();
                System.out.println("\n\t NO MATCH FOUND FOR DELETE\n\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
