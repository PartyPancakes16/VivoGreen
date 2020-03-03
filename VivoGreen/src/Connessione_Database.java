
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connessione_Database {

    Statement stm = null;
    PreparedStatement prepared = null;
    Connection connection = null;

    public Connessione_Database() {
        String connectionString = "jdbc:mysql://localhost:3306/vivogreen";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionString, "root", ""); //Url, Utente, password
            System.out.println("Connessione stabilita");
            stm = connection.createStatement();
            /*ResultSet rs = stm.executeQuery("select * from prodotto"); //query da eseguire
            while (rs.next()) {
                System.out.println(rs.getString("rfid") + " " + rs.getString("descrizione") + " " + rs.getFloat("prezzo") + " " + rs.getFloat("peso") + " " + rs.getDate("scadenza"));                
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // gestione errore in chiusura
            }
        }*/
    }

    public void MostraMagazzino() {
        try {
            ResultSet count = stm.executeQuery("select count(*) from prodotto");
            count.next();
            GlobalApplication.setValori(count.getInt(1), 5);
            ResultSet rs = stm.executeQuery("select * from prodotto");
            while (rs.next()) {
                GlobalApplication.setProdotto(rs.getString("rfid"), rs.getString("descrizione"), rs.getString("prezzo"), rs.getString("peso"), rs.getString("scadenza"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Invio_Dati(String RFID, String prodotto, Double peso, Double prezzo, String scadenza) {
        try {
            System.out.println("Entro in invia dati");

            prepared = connection.prepareStatement("INSERT INTO prodotto (RFID,descrizione,prezzo,peso,scadenza)" + " VALUES (?,?,?,?,?)");
            System.out.println("creo lo statement");
            prepared.setString(1, RFID);
            System.out.println("1");
            prepared.setString(2, prodotto);
            System.out.println("2");
            prepared.setDouble(3, prezzo);
            System.out.println("3");
            prepared.setDouble(4, peso);
            System.out.println("4");
            prepared.setString(5, scadenza);
            System.out.println("5");
            prepared.executeUpdate();
            System.out.println("Fine inserimento");
        } catch (SQLException ex) {
            Logger.getLogger(Connessione_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
    }
}
