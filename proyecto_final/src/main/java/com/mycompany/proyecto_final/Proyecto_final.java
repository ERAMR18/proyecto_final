/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import java.util.Scanner;
import clases.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ramir
 */
public class Proyecto_final {

    private static final String DIRECTORY_NAME = "registros";
    private static final String FILE_PERSONAS = DIRECTORY_NAME + "/Personas.txt";
    private static final String FILE_SALONES = DIRECTORY_NAME + "/Salones.txt";
    
    public static void main(String[] args) {
   Scanner entrada = new Scanner(System.in);
   int opcion = 0;
   int salida = 0;
   
   while(salida != 1){
            System.out.println("Menu Proyecto 1 programacion 2024 Grupo #");
            System.out.println("\t 1. Ingresar alumno");
            System.out.println("\t 2. Buscar alumno por CUI");
            System.out.println("\t 3. modificar alumno por CUI");
            System.out.println("\t 11. Salir"); 
            
            try{ 
            opcion = entrada.nextInt();
            } catch(Exception e){
                System.out.println("Error:" + e);
            }
            switch(opcion){
             case 1: 
                    System.out.println("Problema 1");
                    funcion_1();
                    break;
                    
            case 2: 
                    Scanner entrada2 = new Scanner(System.in);
                    System.out.println("Ingrese el CUI: ");
                    String cui = entrada2.nextLine();
                    Persona person = buscarPersonaPorCUI(cui);
                    if (person!=null ) {
                     person.showPerson();
                     break;
                }                   
                    break;
                    
            case 3:
                    Scanner entrada3 = new Scanner(System.in);
                    System.out.println("Ingrese el CUI a modificar: ");
                    String cuiMod = entrada3.nextLine();
                    Persona personMod = buscarPersonaPorCUI(cuiMod);
                    boolean modificarN = true;
                    boolean modificarA = true;
                    boolean modificarNT = true;
                    String nombre = personMod.getNombre();
                    String apellido = personMod.getApellidos();
                    String numero_telefono = personMod.getApellidos();
                    
                    if (personMod!=null ) {
                        System.out.println("Persona a modificar");
                        personMod.showPerson();
                     
                    } 
                    
                    System.out.println("¿Desea modificar nombres? 1. SI 2. NO");
                    int n = entrada3.nextInt(); 
                    entrada3.nextLine();
                    if (n == 1) {
                        System.out.println("Ingrese el nombre a modificar: ");
                        nombre = entrada3.nextLine();
                    }
                    
                    System.out.println("¿Desea modificar apellidos? 1. SI 2. NO");
                    int n2 = entrada3.nextInt();
                    entrada3.nextLine();
                    if (n2 == 1) {
                        System.out.println("Ingrese los apellidos a modificar: ");
                        apellido = entrada3.nextLine();
                    }
                    
                    System.out.println("¿Desea modificar el numero de telefono? 1. SI 2. NO");
                    int n3 = entrada3.nextInt();
                    entrada3.nextLine();
                    if (n3 == 1) {
                        System.out.println("Ingrese el numero de telefono a modificar: ");
                        numero_telefono = entrada3.nextLine();
                        
                        while(!validarNumeroCelular(numero_telefono)){
                            System.out.println("Numero de celular invalido solo se permiten digitos");
                            System.out.println("Ingrese nuevamente el numero de celular: ");
                            numero_telefono = entrada3.nextLine();
                        }
                    }
                    
                    System.out.println("Datos: ");
                    System.out.println(nombre);
                    System.out.println(apellido);
                    System.out.println(numero_telefono);
                    
                    Persona personaNueva = new Persona(cuiMod, nombre, apellido, numero_telefono);
                    modificarPersonaPorCUI(cuiMod, personaNueva); //String CUI, Persona nuevaPersona
                    break;
                    
                
                case 11:
                    System.out.println("");
                    salida = 1;
                    break;
                default: System.out.println("error");
                break;
        
        
            }   
        }
    }
    
    public static void funcion_1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Ingrese el el cui: ");
        String cui = scanner.nextLine(); 
        while (!validarCUI(cui)) {
                        System.out.println("CUI invalido. Debe contener exactamente 13 caracteres numericos.");
                        System.out.print("Ingrese CUI (13 dígitos): ");
                        cui = scanner.nextLine();
       
        }
        
         Persona person = buscarPersonaPorCUI(cui);
         if (person!= null) {
             System.out.println("Esta persona ya fue ingresada");
             person.showPerson();
            
        }else{
         System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido: "); 
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su numero celular: ");
        String numero_celular = scanner.nextLine();
        
        while(!validarNumeroCelular(numero_celular)){
                System.out.println("Numero de celular invalido solo se permiten digitos");
                System.out.println("Ingrese nuevamente el numero de celular: ");
                numero_celular = scanner.nextLine();
        }
        
        Persona  persona = new Persona(cui, nombre, apellido, numero_celular);
        System.out.println("Persona ingresada: ");
        System.out.println(persona.toString());
        
        registrarPersona(persona);
         }
        
        
       }
    
    public static boolean validarCUI(String CUI) {
        return CUI.matches("\\d{13}");
    }
    
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
    
    
    public static boolean validarNumeroCelular (String numero_celular) {
        return numero_celular.matches("\\d+");
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
    
   
    
    
    }

