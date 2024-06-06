/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import java.util.Scanner;
import clases.Persona;
import java.io.*;
import Metodos.Metodos_Persona;

/**
 *
 * @author ramir
 */
public class Proyecto_final {
    
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
                    Persona person = Metodos_Persona.buscarPersonaPorCUI(cui);
                    if (person!=null ) {
                     person.showPerson();
                     break;
                }                   
                    break;
                    
            case 3:
                    Scanner entrada3 = new Scanner(System.in);
                    System.out.println("Ingrese el CUI a modificar: ");
                    String cuiMod = entrada3.nextLine();
                    Persona personMod = Metodos_Persona.buscarPersonaPorCUI(cuiMod);
                    String nombre = null;
                    String apellido = null;
                    String numero_telefono = null;
                    
                    if (personMod!=null ) {
                        System.out.println("Persona a modificar");
                        personMod.showPerson();
                        
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

                                while(!Metodos_Persona.validarNumeroCelular(numero_telefono)){
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
                            Metodos_Persona.modificarPersonaPorCUI(cuiMod, personaNueva); //String CUI, Persona nuevaPersona
                     
                    } else {
                        System.out.println("Persona no encontrada");
                    
                    }
                    
         
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
        while (!Metodos_Persona.validarCUI(cui)) {
                        System.out.println("CUI invalido. Debe contener exactamente 13 caracteres numericos.");
                        System.out.print("Ingrese CUI (13 dígitos): ");
                        cui = scanner.nextLine();
       
        }
        
         Persona person = Metodos_Persona.buscarPersonaPorCUI(cui);
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
        
        while(!Metodos_Persona.validarNumeroCelular(numero_celular)){
                System.out.println("Numero de celular invalido solo se permiten digitos");
                System.out.println("Ingrese nuevamente el numero de celular: ");
                numero_celular = scanner.nextLine();
        }
        
        Persona  persona = new Persona(cui, nombre, apellido, numero_celular);
        System.out.println("Persona ingresada: ");
        System.out.println(persona.toString());
        
        Metodos_Persona.registrarPersona(persona);
         }
        
        
       }
    
 
 }















