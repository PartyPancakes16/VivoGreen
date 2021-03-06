
import com.caen.RFIDLibrary.CAENRFIDException;
import com.caen.RFIDLibrary.CAENRFIDLogicalSource;
import com.caen.RFIDLibrary.CAENRFIDPort;
import com.caen.RFIDLibrary.CAENRFIDReader;
import com.caen.RFIDLibrary.CAENRFIDTag;
import com.caen.RFIDLibrary.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aniel
 */
public class Cassa extends javax.swing.JFrame {

    /**
     * Creates new form Cassa
     */
    
    
    CAENRFIDTag[] MyTags = null;
CAENRFIDReader MyReader = new CAENRFIDReader();
CAENRFIDLogicalSource MySource=null;

           
    
    public Cassa() throws CAENRFIDException {
        initComponents();
            MyReader.Connect(CAENRFIDPort.CAENRFID_TCP, "192.168.0.2");
            System.out.println("pp");
            MySource = MyReader.GetSource("Source_0");
            MySource.AddReadPoint("Ant1");
            
        
        
    

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CASSA");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prodotto", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable3);

        jLabel2.setText("Totale =");

        jButton1.setText("LEGGI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TERMINA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        System.out.println(model.getRowCount());
        if (model.getRowCount() != 0) {
            for (int i = model.getRowCount() - 1; i >= 0; i--) {

                System.out.println("Rimuovo la riga " + i);
                model.removeRow(i);

            }
        }
        String s = "";
        String url = "jdbc:mysql://localhost:3306/vivogreen";
        Connection con;
        String q = "";
        Double totale = 0.0;
        String RFID = "";
        int errore = 0;
        
        String descrizione = "";
        Double prezzo = 0.0;

        
        System.out.println("prova");
        
        try {

            //apertura file su cui scrivere
            FileWriter f1 = null;
            try {
                f1 = new FileWriter("C:\\Users\\filic\\OneDrive\\Documents\\GitHub\\VivoGreen\\VivoGreen\\tags_old.txt"); //true per aprire un file esistente
            } catch (IOException ex) {
                Logger.getLogger(Cassa.class.getName()).log(Level.SEVERE, null, ex);
            }
            PrintWriter fOUT = new PrintWriter(f1);

            System.out.println("se");

            //MySource.AddReadPoint("Ant2"); 
            //MySource.AddReadPoint("Ant3"); 
            //MySource.SetReadCycle(1000);
            //MyReader.SetPower(100);

            MyTags = MySource.InventoryTag();
            
            System.out.println("prova2");
            //MyTags = new CAENRFIDTag[1000];
            System.out.println("ll");
            
            System.out.println("gg");
            try {
                int length = MyTags.length;
                System.out.println(length);
            } catch (NullPointerException e) {
                errore = 1;
                System.out.println("ECCEZIONE: NESSUN PRODOTTO PRESENTE NELL'AREA DI LETTURA.");
                System.out.println();
            }

            if (errore == 1) {
            } else {
                if (MyTags.length > 0) {
                    System.out.println("RFID LETTI NEL CARRELLO:");
                    System.out.println("");
                    for (int i = 0; i < MyTags.length; i++) {
                        byte b[] = new byte[100];
                        b = (MyTags[i].GetId());
                        StringBuilder str = new StringBuilder();
                        for (byte prova : b) {
                            str.append(String.format("%02x", prova));
                        }
                        RFID = str.toString();

                        System.out.println(RFID);
                        System.out.println("");

                        fOUT.println(RFID);
                        fOUT.flush();//invio dati

                    }
                    //System.out.println("Ho letto i prodotti dal carrello");
                    MyReader.Disconnect();
                    f1.close();

                }

                Statement stmt;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.err.println("ClassNotFoundException");
                    System.err.println(e.getMessage());
                }
                //fine connessione db       

                //lettura da file di testo per ogni riga
                try {
                    FileReader f = new FileReader("C:\\Users\\filic\\OneDrive\\Documents\\GitHub\\VivoGreen\\VivoGreen\\tags_old.txt");//++++ ATTENZIONE A DOVE POSIZIONO IL FILE +++++
                    BufferedReader fIN = new BufferedReader(f);

                    System.out.println("CONFRONTO GLI RFID CON I PRODOTTI PRESENTI NEL DATABASE E RECUPERO IL NOME ED IL PREZZO DEL PRODOTTO:");
                    System.out.println("");
                    while (s != null) {

                        s = fIN.readLine();

                        q = "Select * from prodotto where rfid = '" + s + "'";
                        //eseguo la select per ogni riga letta da file
                        try {
                            con = DriverManager.getConnection(url, "root", "");
                            stmt = con.createStatement();
                            ResultSet rs;

                            rs = stmt.executeQuery(q);
                            int c = 0;//contatore per verificare se l'rfid è presente nel db
                            while (rs.next()) {
                                c++;
                                //String codice = rs.getString("codice");
                                //System.out.print(codice + "\t");

                                descrizione = rs.getString("descrizione");
                                System.out.print(descrizione + "\t\t\t");

                                prezzo = rs.getDouble("prezzo");
                                System.out.println(prezzo + " €");
                                totale = totale + prezzo;
                                jLabel2.setText(String.valueOf(totale));
                            }

                            //if(c==1)System.out.println("prodotto trovato");
                            //else if (c==0 && s!=null) System.out.println("prodotto non trovato");
                            if (c == 0 && s != null) {
                                System.out.println("prodotto non presente nel DB");
                            }

                            stmt.close();
                            con.close();
                        } catch (SQLException e) {
                            System.err.println("SQLException: ");
                            System.err.println(e.getMessage());
                        }
                        //fine select

                        //System.out.println(s);
                    }//fine while di lettura per ogni riga del file txt
                    f.close();

                    System.out.println();
                    System.out.println("IL TOTALE DA PAGARE E' " + totale + " €");
                    System.out.println();

                } catch (IOException e) {
                    System.out.println("errore nell'apertura del file " + e);
                    System.exit(1);
                }

            }//fine else
        } catch (CAENRFIDException ex) {
            Logger.getLogger(Cassa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cassa.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (s != null) {
        } else {
            for (int i = 0; i < MyTags.length; i++) {
                model.addRow(new Object[]{descrizione, prezzo});
                System.out.println("aggiungo la riga " + i);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire?", "Vivogreen Information", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setVisible(false);
            dispose();
            Menu m = new Menu();
            m.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cassa().setVisible(true);
                } catch (CAENRFIDException ex) {
                    Logger.getLogger(Cassa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
