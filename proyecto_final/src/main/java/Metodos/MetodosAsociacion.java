package Metodos;

import clases.Asociacion;
import clases.Curso;
import clases.Persona;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MetodosAsociacion {

    private static final String DIRECTORY_NAME = "registros";
    private static final String FILE_ASOCIACION = DIRECTORY_NAME + "/“registrocursos.txt";
    private static final String FILE_AULAS = DIRECTORY_NAME + "/Aulas.txt";
    private static final String FILE_CURSOS = DIRECTORY_NAME + "/Cursos.txt";
    private static final String FILE_PERSONAS = DIRECTORY_NAME + "/Personas.txt";

    private final MetodosCurso metodosCurso = new MetodosCurso();
    private final MetodosPersona metodosPersona = new MetodosPersona();

    public static void asociar(Asociacion asociacion) {
        // Verificar y crear el folder si no existe
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (!validarCUI(asociacion.getCui())) {
            System.out.println("El CUI ingresado no es válido.");
            return;
        }

        if (!validarFecha(asociacion.getFecha())) {
            System.out.println("La fecha ingresada no es válida.");
            return;
        }

        // Verificar si el aula existe
        if (!buscarAulaPorCodigoMostrar(asociacion.getNumeroAula())) {
            System.out.println("El aula ingresada no existe.");
            return;
        }

        // Verificar si el curso existe
        if (!buscarCursoPorCodigo(asociacion.getCodigoCurso())) {
            System.out.println("El curso ingresado no existe.");
            return;
        }

        // Verificar si la persona existe
        if (!buscarPersonaPorCUI(asociacion.getCui())) {
            System.out.println("La persona ingresada no existe.");
            return;
        }

        // Escribir los datos en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ASOCIACION, true))) {
            bw.write(asociacion.toString());
            bw.newLine();
            System.out.println("Asociacion registrada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static boolean validarCUI(String CUI) {
        return CUI.matches("\\d{13}");
    }

    public static boolean validarFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean buscarPersonaPorCUI(String CUI) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PERSONAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(CUI)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return Boolean.FALSE; // Retorna null si no se encuentra la persona
    }

    public static Boolean buscarAulaPorCodigoMostrar(String AULA) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_AULAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String campoBusqueda = datos[1];
                if (campoBusqueda.equalsIgnoreCase(AULA)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return Boolean.FALSE;
    }

    public static void mostrarAula(String search) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_ASOCIACION))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String campoBusqueda = datos[0] + " " + datos[1];
                if (search.isEmpty()) {
                    System.out.println(campoBusqueda);
                } else {
                    if (campoBusqueda.contains(search)) {
                        System.out.println(campoBusqueda);
                        return;
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static Boolean buscarCursoPorCodigo(String CODIGO) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_CURSOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String campoBusqueda = datos[0];
                if (campoBusqueda.equalsIgnoreCase(CODIGO)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return Boolean.FALSE; // Retorna null si no se encuentra la persona
    }
}
