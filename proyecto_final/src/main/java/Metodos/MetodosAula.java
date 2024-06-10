/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;
import java.io.*;
import clases.Aula;
/**
 *
 * @author ramir
 */
public class MetodosAula {
    private static final String DIRECTORY_NAME = "registros";
    private static final String FILE_AULAS= DIRECTORY_NAME + "/Aulas.txt";
    
    public static void registrarAula(Aula aula) {
        // Verificar y crear el folder si no existe
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Escribir los datos en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_AULAS, true))) {
            bw.write(aula.toString());
            bw.newLine();
            System.out.println("Aula registrada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    
           public static void  buscarAulaPorCodigoMostrar(String AULA) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_AULAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String campoBusqueda = datos[0] + " " + datos[1];
                if (campoBusqueda.contains(AULA)) {
                    System.out.println(campoBusqueda);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public static boolean modificarAulaPorCodigo(String numeroAula, Aula nuevaAula) {
        File inputFile = new File(FILE_AULAS);
        File tempFile = new File(DIRECTORY_NAME + "/tempAulas.txt");

        boolean encontrada = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(numeroAula)) {
                    bw.write(nuevaAula.toString());
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
