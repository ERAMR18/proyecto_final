/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import Metodos.MetodosAsociacion;
import Metodos.MetodosAula;
import Metodos.MetodosCurso;

import java.util.Scanner;

import clases.Persona;

import java.io.*;

import Metodos.MetodosPersona;
import clases.Asociacion;
import clases.Aula;
import clases.Curso;

/**
 * @author ramir
 */
public class Proyecto_final {

    public static void main(String[] args) {

        int opcion = 0;
        int salida = 0;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Menu Proyecto 1 programacion 2024 Grupo #");
            System.out.println("\t 1. Ingresar alumno");
            System.out.println("\t 2. Buscar alumno por CUI");
            System.out.println("\t 3. modificar alumno por CUI");
            System.out.println("\t 4. Ingresar curso");
            System.out.println("\t 5. Buscar curso por codigo o por nombre del curso");
            System.out.println("\t 6.Mostrar cursos registrados");
            System.out.println("\t 7. Modificar Curso"); 
            System.out.println("\t 8. Registrar Aula"); 
            System.out.println("\t 9. Modificar Aulas"); 
            System.out.println("\t 10. Consulta de aulas por numero de aula o mostrar las auias registradas"); 
            System.out.println("\t 11. Registre una persona/curso/aula");
            System.out.println("\t 12. Mostrar asociaciones registradas");


            

            System.out.println("\t 13. Salir");

            try {
                //opcion = entrada.nextInt();
                //entrada.nextLine();
                opcion = Integer.parseInt(entrada.next());
                System.out.println("Nmero introducido: " + opcion);


            } catch (Exception e) {
                System.out.println("Error:" + e);
            }
            switch (opcion) {
                case 1:
                    System.out.println("Problema 1");
                    registrarPersona();
                    break;

                case 2:
                    Scanner entrada2 = new Scanner(System.in);
                    System.out.println("Ingrese el CUI: ");
                    String cui = entrada2.nextLine();
                    Persona person = MetodosPersona.buscarPersonaPorCUI(cui);
                    if (person != null) {
                        person.showPerson();
                        break;
                    }
                    break;

                case 3:
                    Scanner entrada3 = new Scanner(System.in);
                    System.out.println("Ingrese el CUI a modificar: ");
                    String cuiMod = entrada3.nextLine();
                    Persona personMod = MetodosPersona.buscarPersonaPorCUI(cuiMod);
                    String nombre = null;
                    String apellido = null;
                    String numeroTelefono = null;

                    if (personMod != null) {
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
                            numeroTelefono = entrada3.nextLine();

                            while (!MetodosPersona.validarNumeroCelular(numeroTelefono)) {
                                System.out.println("Numero de celular invalido solo se permiten digitos");
                                System.out.println("Ingrese nuevamente el numero de celular: ");
                                numeroTelefono = entrada3.nextLine();
                            }
                        }

                        System.out.println("Datos: ");
                        System.out.println(nombre);
                        System.out.println(apellido);
                        System.out.println(numeroTelefono);

                        Persona personaNueva = new Persona(cuiMod, nombre, apellido, numeroTelefono);
                        MetodosPersona.modificarPersonaPorCUI(cuiMod, personaNueva); //String CUI, Persona nuevaPersona

                    } else {
                        System.out.println("Persona no encontrada");

                    }


                    break;

                case 4: {
                    System.out.println("Problema 2");
                    registrarCurso();
                    break;
                }

                case 5: {
                   //Scanner entradaCurso = new Scanner(System.in);
                   
                   System.out.println("'Ingrese el codigo de curso para consulta'");
                   String CODIGO = entrada.next();
         
                    Curso curso =   MetodosCurso.buscarCursoPorCodigo(CODIGO);
                    if (curso == null) {
                        System.out.println("No se encontro el curso");
                    }else{
                    System.out.println("El codigo es para el curso");
                    System.out.println("El nombre del curso es: " + curso.getNombreCurso());
                    System.out.println("El codigo de curso es de:  " + curso.getCodigoCurso());
                    System.out.println("El numero de semestre es de:  " + curso.getSemestre());
                    }
                  
                    //entradaCurso.close();
                    
                    break;
                }
                
                case 6: {
                    System.out.println("ILos cursos ingresados con los siguientes: ");
                    MetodosCurso.mostrarCursos();
                    break;
                }
                
                case 7:{
                 //Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo de curso que quiere actualizar");
        String codigoCurso = entrada.next();
        System.out.println("Ingrese el nuevo nombre del curso");
        String nombreCurso = entrada.next();
        System.out.println("Ingrese el nuevo numero de semestre");
        String semestre = entrada.next();


        while (!MetodosCurso.validarCodigo(codigoCurso)) {
            System.out.println("Codigo de curso invalida. Debe contener unicamente valores numericos.");
            System.out.print("Ingrese el codigo de curso (13 dígitos): ");
            codigoCurso = entrada.next();

        }
         Curso cursoMod = new Curso();
         cursoMod.setCodigoCurso(codigoCurso);
         cursoMod.setNombreCurso(nombreCurso);
         cursoMod.setSemestre(semestre);
        MetodosCurso.modificarCursoPorCodigo(codigoCurso, cursoMod);
        break;
                }
                
                case 8:{
                    System.out.println("Registrar aula");
                    registrarAula(entrada);
                    break;
                }
                
                case 9: {
                    System.out.println("Consulta de aula por numero de aula (.1) o mostrar registros (.2) ");
                    String opcionConsulta = entrada.next();
                    String numeroAula = "";
                   
                    if (opcionConsulta.equals("1")) {
                        System.out.println("Ingrese el numero de aula");
                        numeroAula = entrada.next();
                    }
                    MetodosAula.buscarAulaPorCodigoMostrar(numeroAula);
                    break;
                }

                case 10:{
                    //Scanner scanner = new Scanner(System.in);
                        System.out.println("Ingrese el numero de aula: ");
                        String numeroAula = entrada.next();
                        Aula nuevaAula = new Aula();
                        System.out.println("ingrese la nueva ubicacion del aula");
                        String ubicacionAula = entrada.next();
                        nuevaAula.setUbicacionAula(ubicacionAula);
                        System.out.println("Ingrese la nueva capacidad de escritorios");
                        String capacidadEscritorios = entrada.next();
                        nuevaAula.setCapacidadEscritorios(capacidadEscritorios);
                        nuevaAula.setNumeroAula(numeroAula);
                        MetodosAula.modificarAulaPorCodigo(numeroAula, nuevaAula);
                        //entrada.close();
                        break;
                }

                
                case 11:{
                    System.out.println("Ingrese un numero de cui");
                    String dpi = entrada.next();
                    System.out.println("Ingrese codigo de curso");
                    String cursoCodigo = entrada.next();
                    System.out.println("Ingrese un numero de aula");
                    String aulaNum = entrada.next();
                    System.out.println("Ingrese un fecha dd/MM/yyyy");
                    String fecha = entrada.next();
                    Asociacion asociacion = new Asociacion();
                    asociacion.setCui(dpi);
                    asociacion.setCodigoCurso(cursoCodigo);
                    asociacion.setNumeroAula(aulaNum);
                    asociacion.setFecha(fecha);
                    MetodosAsociacion.asociar(asociacion);
                    break;
                }
                
                case 12:{
                    System.out.println("Consulta de aula por CUI o por codigo de curso (.1) o mostrar registros (.2) ");
                   String opcionConsulta = entrada.next();
                   String busqueda = "";

                   if (opcionConsulta.equals("1")) {
                       System.out.println("Ingrese el numero de CUI o Codigo de curso");
                       busqueda = entrada.next();
                   }
                MetodosAsociacion.mostrarAula(busqueda);
                break;
                }


                case 13:
                    System.out.println("");
                    salida = 1;
                    break;
                default:
                    System.out.println("error");
                    break;


            }
        } while (salida != 1);
        entrada.close();
    }

    public static void registrarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Ingrese el el cui: ");
        String cui = scanner.nextLine();
        while (!MetodosPersona.validarCUI(cui)) {
            System.out.println("CUI invalido. Debe contener exactamente 13 caracteres numericos.");
            System.out.print("Ingrese CUI (13 dígitos): ");
            cui = scanner.nextLine();

        }

        Persona person = MetodosPersona.buscarPersonaPorCUI(cui);
        if (person != null) {
            System.out.println("Esta persona ya fue ingresada");
            person.showPerson();

        } else {
            System.out.println("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido: ");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese su numero celular: ");
            String numeroCelular = scanner.nextLine();

            while (!MetodosPersona.validarNumeroCelular(numeroCelular)) {
                System.out.println("Numero de celular invalido solo se permiten digitos");
                System.out.println("Ingrese nuevamente el numero de celular: ");
                numeroCelular = scanner.nextLine();
            }

            Persona persona = new Persona(cui, nombre, apellido, numeroCelular);
            System.out.println("Persona ingresada: ");
            System.out.println(persona.toString());

            MetodosPersona.registrarPersona(persona);
        }


    }


    public static void registrarCurso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo de curso");
        String codigoCurso = scanner.nextLine();
        System.out.println("Ingrese el nombre de curso");
        String nombreCurso = scanner.nextLine();
        System.out.println("Ingrese el numero de semestre");
        String semestre = scanner.nextLine();


        while (!MetodosCurso.validarCodigo(codigoCurso)) {
            System.out.println("Codigo de curso invalida. Debe contener unicamente valores numericos.");
            System.out.print("Ingrese el codigo de curso (13 dígitos): ");
            codigoCurso = scanner.nextLine();

        }
        Curso curso = new Curso(codigoCurso, nombreCurso, semestre);

        MetodosCurso.registrarCurso(curso);
        //scanner.close();

    }


    public static void registrarAula(Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de aula");
        String numeroAula = scanner.next();
        System.out.println("Ingrese la ubicacion del aula");
        String ubicacionAula = scanner.next();
        System.out.println("ingrese la capacidad de escritorios");
        String capacidadEscritorios = scanner.next();
        Aula aula = new Aula();

        aula.setCapacidadEscritorios(capacidadEscritorios);
        aula.setNumeroAula(numeroAula);
        aula.setUbicacionAula(ubicacionAula);

        MetodosAula.registrarAula(aula);
        //scanner.close();
    }


}