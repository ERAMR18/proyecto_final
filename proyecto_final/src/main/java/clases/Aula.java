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
    private String numero_aula;
    private String ubicacion_aula;
    private String capacidad_escritorios;

    public Aula(String numero_aula, String ubicacion_aula, String capacidad_escritorios) {
        this.numero_aula = numero_aula;
        this.ubicacion_aula = ubicacion_aula;
        this.capacidad_escritorios = capacidad_escritorios;
    }

    public String getNumero_aula() {
        return numero_aula;
    }

    public void setNumero_aula(String numero_aula) {
        this.numero_aula = numero_aula;
    }

    public String getUbicacion_aula() {
        return ubicacion_aula;
    }

    public void setUbicacion_aula(String ubicacion_aula) {
        this.ubicacion_aula = ubicacion_aula;
    }

    public String getCapacidad_escritorios() {
        return capacidad_escritorios;
    }

    public void setCapacidad_escritorios(String capacidad_escritorios) {
        this.capacidad_escritorios = capacidad_escritorios;
    }
    
    
    

    
    
}
