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
    private String numeroCelular;
    
    public Persona (String cui, String nombre, String apellidos, String numeroCelular){
        this.cui = cui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroCelular = numeroCelular;
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
     * @return the numeroCelular
     */
    public String getNumeroCelular() {
        return numeroCelular;
    }

    /**
     * @param numeroCelular the numeroCelular to set
     */
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
@Override
     public String toString() {
        return cui + "," + nombre + "," + apellidos + "," + numeroCelular;
    }
     
     public void showPerson(){
         System.out.println("\t CUI: " + cui );
         System.out.println("\t Nombre: " + nombre );
         System.out.println("\t Apellidos: " + apellidos );
         System.out.println("\t Numero de celular: " + numeroCelular );
     }
    
}
