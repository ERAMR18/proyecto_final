/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;
import java.io.*;
import clases.Curso;

/**
 *
 * @author ramir
 */
public class Metodos_Curso {
    private static final String DIRECTORY_NAME = "registros";
    private static final String FILE_CURSOS = DIRECTORY_NAME + "/Cursos.txt";
    
    public static void registrarCurso(Curso curso) {
        // Verificar y crear el folder si no existe
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Escribir los datos en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_CURSOS, true))) {
            bw.write(curso.toString());
            bw.newLine();
            System.out.println("curso registrado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    
       public static boolean modificarCursoPorCodigo(String codigo_curso, Curso nuevoCurso) {
        File inputFile = new File(FILE_CURSOS);
        File tempFile = new File(DIRECTORY_NAME + "/tempCursos.txt");

        boolean encontrada = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(codigo_curso)) {
                    bw.write(nuevoCurso.toString());
                    encontrada = true;
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
            return false;
        }

        // Reemplazar el archivo original con el archivo temporal
        if (!inputFile.delete()) {
            System.err.println("No se pudo eliminar el archivo original");
            return false;
        }

        if (!tempFile.renameTo(inputFile)) {
            System.err.println("No se pudo renombrar el archivo temporal");
            return false;
        }

        return encontrada;
    }
}
