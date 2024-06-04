/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author ramir
 */
public class Persona {
    private String cui;
    private String nombre;
    private String apellidos;
    private String numero_celular;
    
    public Persona (String cui, String nombre, String apellidos, String numero_celular){
        this.cui = cui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero_celular = numero_celular;
    }

    /**
     * @return the cui
     */
    public String getCui() {
        return cui;
    }

    /**
     * @param cui the cui to set
     */
    public void setCui(String cui) {
        this.cui = cui;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the numero_celular
     */
    public String getNumero_celular() {
        return numero_celular;
    }

    /**
     * @param numero_celular the numero_celular to set
     */
    public void setNumero_celular(String numero_celular) {
        this.numero_celular = numero_celular;
    }
@Override
     public String toString() {
        return cui + "," + nombre + "," + apellidos + "," + numero_celular;
    }
     
     public void showPerson(){
         System.out.println("\t CUI: " + cui );
         System.out.println("\t Nombre: " + nombre );
         System.out.println("\t Apellidos: " + apellidos );
         System.out.println("\t Numero de celular: " + numero_celular );
     }
    
}
