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
            ResultSet rs = stm.executeQuery("select * from anagrafica"); //query da eseguire
            while (rs.next()) {
                System.out.println(rs.getInt("PK_Persona") + " " + rs.getString("Nome") + " " + rs.getString("Cognome") + " di anni " + rs.getInt("Età") + " " + rs.getDate("Data_nascita") + " " + rs.getString("Sesso") + " " + rs.getString("Luogo_nascita") + " " + rs.getString("Residenza"));
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
