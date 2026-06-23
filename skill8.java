package org.example;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class skill8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // JDBC connection variables
        String url = "jdbc:mysql://localhost:3306/wildlifeDB"; // replace with your database name
        String user = "root"; // replace with your MySQL username
        String password = "hari@1098"; // replace with your MySQL password

        Connection con = null;
        PreparedStatement pst = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            con = DriverManager.getConnection(url, user, password);

            // SQL Insert statement
            String sql = "INSERT INTO Species (Name, Category, Image, DescriptionFile) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);

            // Loop for 8 records
            for (int i = 1; i <= 8; i++) {
                System.out.println("\n--- Enter details for record " + i + " ---");

                System.out.print("Enter Name of the species: ");
                String name = sc.nextLine();

                System.out.print("Enter Category (Animal/Plant): ");
                String category = sc.nextLine();

                System.out.print("Enter full path of the image (.jpg): ");
                String imagePath = sc.nextLine();

                System.out.print("Enter full path of the description file (.txt): ");
                String descPath = sc.nextLine();

                // Set parameters for prepared statement
                pst.setString(1, name);
                pst.setString(2, category);

                // Read image file into InputStream
                File imageFile = new File(imagePath);
                try (FileInputStream fisImage = new FileInputStream(imageFile)) {
                    pst.setBinaryStream(3, fisImage, (int) imageFile.length());

                    // Read description file into String
                    StringBuilder descContent = new StringBuilder();
                    try (BufferedReader br = new BufferedReader(new FileReader(descPath))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            descContent.append(line).append("\n");
                        }
                    }
                    pst.setString(4, descContent.toString());

                    // Execute insert
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Record " + i + " inserted successfully!");
                    } else {
                        System.out.println("Failed to insert record " + i + ".");
                    }
                } catch (IOException e) {
                    System.out.println("Error reading files for record " + i + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}

