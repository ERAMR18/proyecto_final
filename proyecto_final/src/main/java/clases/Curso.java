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
    private String codigoCurso;
    private String nombreCurso;
    private String semestre;
    
    public Curso (String codigoCurso, String nombreCurso, String semestre){
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.semestre = semestre;

    }

    /**
     * @return the codigoCurso
     */
    public String getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * @param codigoCurso the codigoCurso to set
     */
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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
    return this.codigoCurso+"," + this.nombreCurso+"," + this.semestre;
    }

       
}
