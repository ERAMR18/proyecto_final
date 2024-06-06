/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;
import clases.Persona;
import java.io.*;
/**
 *
 * @author ramir
 */
public class Metodos_Persona {
    private static final String DIRECTORY_NAME = "registros";
    private static final String FILE_PERSONAS = DIRECTORY_NAME + "/Personas.txt";
    
    public static void registrarPersona(Persona persona) {
        // Verificar y crear el folder si no existe
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Escribir los datos en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PERSONAS, true))) {
            bw.write(persona.toString());
            bw.newLine();
            System.out.println("Persona registrada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static Persona buscarPersonaPorCUI(String CUI) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PERSONAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(CUI)) {
                    return new Persona(datos[0], datos[1], datos[2], datos[3]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null; // Retorna null si no se encuentra la persona
    }
    
    public static boolean modificarPersonaPorCUI(String CUI, Persona nuevaPersona) {
        File inputFile = new File(FILE_PERSONAS);
        File tempFile = new File(DIRECTORY_NAME + "/tempPersonas.txt");

        boolean encontrada = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(CUI)) {
                    bw.write(nuevaPersona.toString());
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
    
    
    public static boolean validarCUI(String CUI) {
        return CUI.matches("\\d{13}");
    }

    public static boolean validarNumeroCelular(String numeroCelular) {
        return numeroCelular.matches("\\d+");
    }
    
    public static boolean esCUIUnico(String CUI) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PERSONAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(CUI)) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return true;
    }
    
}
