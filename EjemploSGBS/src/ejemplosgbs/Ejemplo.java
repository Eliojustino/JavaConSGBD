package ejemplosgbs;
import java.sql.*;
import javax.swing.JOptionPane;

public class Ejemplo {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver"); //Registrando el driver jdbc
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","CETI");
            Statement s = con.createStatement();
            //s.executeUpdate ("CREATE DATABASE PRUEBA01;");
            //s.executeUpdate("DROP TABLE \"506\";");
            //String inst="CREATE TABLE public. \"506\"(\"id\" Serial PRIMARY KEY,\"nombre\" character varying(255)[] NOT NULL,\"matricula\" character varying(255)[] NOT NULL,\"carrera\" character varying(255)[] NOT NULL);";
            //System.out.println(inst);
            //String nombre = JOptionPane.showInputDialog("Inserta nombre:");
            //String matricula = JOptionPane.showInputDialog("Inserta la matricula:");
            //String carrera = JOptionPane.showInputDialog("Inserta la carrera:");
            //String inst = "INSERT INTO \"506\" (id, nombre, matricula, carrera) values (1, '{"+ nombre + "}', '{"+ matricula +"}', '{" + carrera +"}');";
            //String consulta = "Select * from \"506\";";
            //System.out.println(consulta);
            //s.executeUpdate(inst);
            //ResultSet rs = s.executeQuery(consulta);
            /*if(rs != null){
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt(1));
                    System.out.println("Nombre: " + rs.getString(2));
                    System.out.println("Matricula: " + rs.getString(3));
                    System.out.println("Carrera: " + rs.getString(4));
                    
                }
            }*/
            //String delete = JOptionPane.showInputDialog("Inserta el ID que quieres borrar: ");
            //String inst = "DELETE FROM \"506\" WHERE id = " + delete +";";
            String inst = "SHOW DATABASES;";
            System.out.println(inst);
            //s.executeUpdate(inst);
            ResultSet rs = s.executeQuery(inst);
            if(rs != null){
                System.out.println("Hay base de datos creadas");
            }else{
                System.out.println("No hay base de datos creada");
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
}
