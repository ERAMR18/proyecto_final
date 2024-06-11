package clases;

public class Asociacion {
    private String cui;
    private String codigoCurso;
    private String numeroAula;
    private String fecha;

    public Asociacion() {
    }

    public Asociacion(String cui, String codigoCurso, String numeroAula, String fecha) {
        this.cui = cui;
        this.codigoCurso = codigoCurso;
        this.numeroAula = numeroAula;
        this.fecha = fecha;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(String numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return cui + "," + codigoCurso + "," + numeroAula + "," + fecha;
    }
}
