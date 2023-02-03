
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author esmeldy
 */
public class Productos {
    private Integer codProducto = null;
    private String nombre;
    private Integer cantidad = null;
    private String descripcion;

    public Productos(Integer codProducto, String nombre, Integer cantidad, String descripcion) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Productos() {
    }


    public String altas(){
        String mensaje="";
        //Creacion del fichero de trabajo
        try {
            File fichero = new File("Productos.txt");
            FileWriter fr = new FileWriter(fichero,true);
            
            if (((codProducto != null && !nombre.isEmpty()) && cantidad != null) && !descripcion.isEmpty()){
                
                fr.write(codProducto+System.lineSeparator());
                fr.write(nombre+System.lineSeparator());
                fr.write(cantidad+System.lineSeparator());
                fr.write(descripcion+System.lineSeparator());
                mensaje+="Alta de datos correcta";
                fr.close();
            }
            else {
                mensaje+= "Rellena todos los campos";
            }
        } catch (Exception e) {
            mensaje+="Error al insertar datos. "+e.getMessage();
        }
        
        
        return mensaje;
    }
    
    public String buscar(String c){
        String linea="";
        try {
            File fichero = new File("Productos.txt");
          //  BufferedReader br = new BufferedReader (new FileReader (fichero));
           // codProducto = Integer.parseInt(br.readLine());
           Scanner br = new Scanner(fichero);
           String cp = br.nextLine();
            while (cp!=null){
                String cq = br.nextLine();
                String cr = br.nextLine();
                String ct = br.nextLine();
                if (cp.equals(c)){
                    linea = ("Código de producto: " + cp
                        + "\nNombre: " + cq + "\nCantidad: "
                        + cr + "\nDescripción: " + ct
                        + "\n");
                   
                    break;
                }
                cp = br.nextLine();
                
            }
            br.close();
        } catch (Exception e) {
            
            linea = "Error "+e.getMessage();
                  
        }
        
       return linea; 
    }
    
    public String mostrar () throws FileNotFoundException{
        //Esto se ha puesto en gris y no se cómo quitarlo
        //***********************************************

        String cadena = "";
        String CodP;
        File fichero = new File("Productos.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            CodP = br.readLine();

            while (CodP != null) {
                String NomP = br.readLine();
                String CanP = br.readLine();
                String DesP = br.readLine();
                cadena += ("Código de producto: " + CodP
                        + "\nNombre: " + NomP + "\nCantidad: "
                        + CanP + "\nDescripción: " + DesP
                        + "\n--------------------------" + "\n");
                CodP = br.readLine();
            }

        } catch (Exception e) {
            cadena = "Error en la muestra de registros " + e.getMessage();
        }

        return cadena;
    }
}
