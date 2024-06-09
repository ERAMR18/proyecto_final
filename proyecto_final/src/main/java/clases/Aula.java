/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author ramir
 */
public class Aula {
    private String numeroAula;
    private String ubicacionAula;
    private String capacidadEscritorios;

    public Aula() {
    }
    

    public Aula(String numeroAula, String ubicacionAula, String capacidadEscritorios) {
        this.numeroAula = numeroAula;
        this.ubicacionAula = ubicacionAula;
        this.capacidadEscritorios = capacidadEscritorios;
    }

    public String getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(String numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getUbicacionAula() {
        return ubicacionAula;
    }

    public void setUbicacionAula(String ubicacionAula) {
        this.ubicacionAula = ubicacionAula;
    }

    public String getCapacidadEscritorios() {
        return capacidadEscritorios;
    }

    public void setCapacidadEscritorios(String capacidadEscritorios) {
        this.capacidadEscritorios = capacidadEscritorios;
    }
    

    @Override
    
    public String toString(){
    return this.capacidadEscritorios+ "," + this.numeroAula+ "," + this.ubicacionAula;
    }
    
    
    

    
    
}
