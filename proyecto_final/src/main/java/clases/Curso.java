/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author ramir
 */
public class Curso {
    private String codigo_curso;
    private String nombre_curso;
    private String semestre;
    
    public Curso (String codigo_curso, String nombre_curso, String semestre){
        this.codigo_curso = codigo_curso;
        this.nombre_curso = nombre_curso;
        this.semestre = semestre;

    }

    /**
     * @return the codigo_curso
     */
    public String getCodigo_curso() {
        return codigo_curso;
    }

    /**
     * @param codigo_curso the codigo_curso to set
     */
    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    /**
     * @return the nombre_curso
     */
    public String getNombre_curso() {
        return nombre_curso;
    }

    /**
     * @param nombre_curso the nombre_curso to set
     */
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    @Override
    
    public String toString(){
    return this.codigo_curso+"," + this.nombre_curso+"," + this.semestre;
    }

       
}
