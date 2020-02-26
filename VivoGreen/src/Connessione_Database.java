import java.sql.*;

public class Connessione_Database {

    public static void main(String[] args) {

        String connectionString="jdbc:mysql://localhost:3306/vivogreen";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, "root", ""); //Url, Utente, password
            System.out.println("Connessione stabilita");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from prodotto"); //query da eseguire
            while (rs.next()) {
                System.out.println(rs.getString("rfid") + " " + rs.getString("descrizione") + " " + rs.getFloat("prezzo") + " " + rs.getFloat("peso") + " " + rs.getDate("scadenza"));                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // gestione errore in chiusura
            }
        }

    }

}
