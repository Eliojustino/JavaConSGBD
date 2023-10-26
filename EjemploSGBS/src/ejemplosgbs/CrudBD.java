/**
 * Los botones deben de ser habilitados y desabilidatos dependiendo de lo que
 * se valla haciendo, si no hay base de datos creada todos los botones se 
 * desabilitan y si ya hay una base de datos creada, se desabilita ese boton
 * consulta e inserta estan dasabilitados cuando no hay tablas creadas y cuando 
 * ya hay una tabla creada, se desabilita ese boton y los otros dos se habilitan
 */
package ejemplosgbs;
import java.sql.*;

public class CrudBD extends javax.swing.JFrame {

    public CrudBD() {
        initComponents();
    }
    
    public boolean BDExiste(){
        try{
            Class.forName("org.postgresql.Driver"); //Registrando el driver jdbc
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","CETI");
            Statement s = con.createStatement();
            String inst = "SELECT datname FROM pg_database WHERE datistemplate = false;";
            ResultSet rs = s.executeQuery(inst);
            
            if(rs.next()){
                System.out.println("Hay base de datos creadas");
                while (rs.next()){
                    System.out.println(rs.getString("datname"));
                }
                return true;
            }else{
                System.out.println("No hay base de datos creada");
            }
            
            rs.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CrearBD = new javax.swing.JButton();
        CrearTabla = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CrearBD.setText("Crear BD");

        CrearTabla.setText("Crear Tabla");

        Insertar.setText("Insertar");

        Consultar.setText("Consultar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Insertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CrearBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CrearTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearBD)
                    .addComponent(CrearTabla))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insertar)
                    .addComponent(Consultar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CrudBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudBD().setVisible(true);
                CrudBD frame = new CrudBD();
                frame.setVisible(true);
                if (!BDExiste()) {
                    frame.CrearBD.setEnabled(true);
                    frame.CrearTabla.setEnabled(false);
                    frame.Insertar.setEnabled(false);
                    frame.Consultar.setEnabled(false);
                } else {
                    frame.CrearBD.setEnabled(false);
                    frame.CrearTabla.setEnabled(true);
                    frame.Insertar.setEnabled(true);
                    frame.Consultar.setEnabled(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JButton CrearBD;
    private javax.swing.JButton CrearTabla;
    private javax.swing.JButton Insertar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
