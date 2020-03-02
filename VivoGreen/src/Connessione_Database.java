import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connessione_Database {
    Statement stm=null;
    public Connessione_Database()
    {
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
            stm = connection.createStatement();
            /*ResultSet rs = stm.executeQuery("select * from prodotto"); //query da eseguire
            while (rs.next()) {
                System.out.println(rs.getString("rfid") + " " + rs.getString("descrizione") + " " + rs.getFloat("prezzo") + " " + rs.getFloat("peso") + " " + rs.getDate("scadenza"));                
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } /*finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // gestione errore in chiusura
            }
        }*/
    }

    public void MostraMagazzino()
    {
        try
        {
            ResultSet count = stm.executeQuery("select count(*) from prodotto");
            count.next();
            GlobalApplication.setValori(count.getInt(1), 5);
            ResultSet rs = stm.executeQuery("select * from prodotto");
            while (rs.next()) {
                GlobalApplication.setProdotto(rs.getString("rfid"),rs.getString("descrizione"),rs.getString("prezzo"),rs.getString("peso"),rs.getString("scadenza"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void Invio_Dati(String RFID,String prodotto,Double peso,Double prezzo,String scadenza)
    {
        try {
            ResultSet ins = stm.executeQuery("INSERT INTO prodotto (rfid,descrizione,prezzo,peso,scadenza) VALUES (RFID,descrizione,prezzo,peso,scadenza)");
        } catch (SQLException ex) {
            Logger.getLogger(Connessione_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
    }
}