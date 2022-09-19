package es.crisminu;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        /*Una que permita administración básica de ficheros y carpetas a través de una interfaz de texto diseñada
         por ti.*/

        boolean acceso = true;

        while(acceso == true){
            int opcion=0;
            System.out.println("Bienvenido. Seleccione una acción:");
            System.out.println("1. Listar");
            System.out.println("2. Crear directorio");
            System.out.println("3. Crear archivo");
            System.out.println("4. Renombrar");
            System.out.println("5. Borrar");
            System.out.println("6. Salir");
            opcion = sc.nextInt();

            switch(opcion){
                case 1: //Listar directorio
                    listar();
                    break;
                case 2: //Crear directorio
                    crearDir();
                    break;
                case 3: //Crear archivo
                    crearArchivo();
                    break;
                case 4: //Renombrar
                    renombrar();
                    break;
                case 5: //Crear archivo nuevo
                    borrar();
                    break;
                case 6: //Borrar archivo
                    acceso = false;
                    System.out.println("¡Adiós!");
                    break;

            }
        }
    }
    public static void listar() {
        File directorio = new File("ficheros/");
        File [] archivos = directorio.listFiles();

        for(int i=0;i<archivos.length;i++){
            System.out.println(archivos[i].getPath());
        }
    }
    public static void crearDir(){
        String nombreFich = "";
        System.out.println("Introduce el nombre del fichero a crear");
        nombreFich = sc.next();
        File dirCrear = new File("ficheros/" + nombreFich);
        if (!dirCrear.exists()){
            dirCrear.mkdirs();
            System.out.println("Directorio creado con éxito.");
        }
    }
    public static void borrar(){
        String nombre = "";
        System.out.println("Introduce el nombre del fichero u archivo a borrar");
        nombre = sc.next();
        File dirBorrar = new File("ficheros/" + nombre);
        if (dirBorrar.exists()){
            dirBorrar.delete();
            System.out.println("Directorio borrado con éxito.");
        }
    }
    public static void renombrar(){
        String nAnt = "";
        String nNue = "";
        System.out.println("Escriba el nombre del fichero u archivo a renombrar:");
        nAnt = sc.next();
        System.out.println("Escriba el nuevo nombre del fichero u archivo:");
        nNue = sc.next();

        File fAnt = new File("ficheros/" + nAnt);
        File fNue = new File("ficheros/" + nNue);

        if(fAnt.renameTo(fNue)){
            System.out.println("Nombre cambiado con éxito");
        }else{
            System.out.println("No se pudo realizar el cambio");
        }
    }
    public static void crearArchivo(){
        String nombreArch = "";
        System.out.println("Introduce el nombre del archivo a crear");
        nombreArch = sc.next();
        File archCrear = new File("ficheros/" + nombreArch + ".txt/");
        try {
            boolean value = archCrear.createNewFile();
            if (value) {
                System.out.println("Archivo creado");
            }
            else {
                System.out.println("Este archivo ya existe.");
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}



