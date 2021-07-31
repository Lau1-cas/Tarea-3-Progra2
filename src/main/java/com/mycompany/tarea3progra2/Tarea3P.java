/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea3progra2;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Tarea3P {  
    
   private static String[][] comision = new String[5][6];
    private static int [][] sumafila = new  int[5][6];
    private static int [][] sumacolumna = new  int[5][6];
    private static int [][] matriz = new  int[5][6];   
    private static  final int nombre = 0;
    private static  final int ENERO = 1;
    private static  final int FEBRERO = 2;
    private static  final int MARZO = 3;
    private static  final int resultado = 4;
    private static  final int PROMEDIO = 5;
    private static final int enc = 0;
    private static final int totalg = 4;
    
    
           
    private static void Registro(){
       for (int i = 1; i < comision.length-1; i++) {
          CargaInformacion(i);  
        } 
    }
    
    //Funcion para mostrar Textos de Encabezados
    private static void Titulos(){
       comision[enc][nombre]="Nombre";
        comision[enc][ENERO]="ENERO";
        comision[enc][FEBRERO]="FEBRERO";
        comision[enc][MARZO]="MARZO";
        comision[enc][resultado]="Total";
        comision[enc][PROMEDIO]="PROMEDIO";
        comision[totalg][nombre]="TOTAL"; 
    }
    
    //Funcion para Cargar la Informacion a la Matriz.
    public static void CargaInformacion(int Fila){
        Scanner lector = new  Scanner(System.in);
        Titulos();
        System.out.println("Ingrese el nombre de la persona " +(Fila)+":");
        comision[Fila][nombre]=lector.nextLine();
        System.out.println("Ingrese lo del mes de enero");
        comision[Fila][ENERO]=lector.nextLine();
        System.out.println("Ingrese lo del mes de febrero");
        comision[Fila][FEBRERO]=lector.nextLine();
        System.out.println("Ingrese lo del mes de marzo");
        comision[Fila][MARZO]=lector.nextLine();
        
    }
    
    //Funcion para Repetir Sumar los Totales
    private static void TotalDePromediosClientes(){
        for (int i = 1; i < comision.length-1; i++) {
          TotalDePromediosClientes(i);  
        }
    
    }
    
    //Funcion Para el Total de la Persona.
    public static void TotalDePromediosClientes(int fila){
        for (int i = 1; i < comision.length; i++) {
            int total = 0;
            for (int j = 1; j < comision.length-3; j++) {
                for (int k = 1; k < 4; k++) {
                sumafila[j][i]=Integer.parseInt(comision[fila][k]);
                total+=sumafila[j][i];
                comision[fila][resultado]=String.valueOf(total);
                comision[fila][PROMEDIO]=String.valueOf(total/3);
                }
                
            }
            
        }    
    }
    
    //Funcion para Repetir los Grandes Totales
    private static void SumaGranTotal(){
        for (int i = 1; i < comision.length-1; i++) {
            GranTotal(i);  
        }
    
    }
    
    //Funcion para Sumar lo de los tres Meses
    public static void GranTotal(int columnas){
        for (int i = 1; i < comision.length; i++) {
            int total=0,total2=0,total3=0;
            for (int j = 1; j < comision.length-3; j++) {
                for (int k = 1; k < 4; k++) {   
                sumacolumna[j][i]=Integer.parseInt(comision[k][columnas]);
                total+=sumacolumna[j][i];
                comision[totalg][columnas]=String.valueOf(total);
                
                sumacolumna[j][i]=Integer.parseInt(comision[k][resultado]);
                total2+=sumacolumna[j][i];
                comision[totalg][resultado]=String.valueOf(total2);
                
                sumacolumna[j][i]=Integer.parseInt(comision[k][PROMEDIO]);
                total3+=sumacolumna[j][i];
                comision[totalg][PROMEDIO]=String.valueOf(total3);
                    
                }
            }
            
        }
        
    }
    
    //Funcion Para Imprimir la Matriz
     public static void ImprimirMatriz(String[][] Matriz) {
        for (int x = 0; x < Matriz.length; x++) {
            System.out.print("|");
            for (int y = 0; y < Matriz[x].length; y++) {
                System.out.print(Matriz[x][y]);
                if (y != Matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
   
     //Funcion Para Sacar la Venta Mayor de Cada Semana
     public static void MesTotalMayor(int columna,String mes){
         String NombreCliente="";
         int NumMayor=comision.length;
         
         for (int i = 1; i < comision.length-1; i++) {
             int Mayor=0;
            sumafila[i][columna]=Integer.parseInt(comision[i][columna]);
            if(NumMayor < sumafila[i][columna]){
                NumMayor=sumafila[i][columna];
            }
           matriz[1][columna]=Integer.parseInt(comision[1][columna]);
           matriz[2][columna]=Integer.parseInt(comision[2][columna]);
           matriz[3][columna]=Integer.parseInt(comision[3][columna]);
            
           if(matriz[1][columna]> matriz[2][columna]&&matriz[1][columna]> matriz[3][columna]){
               Mayor=1;
               NombreCliente=comision[Mayor][nombre];
           }
           if(matriz[2][columna]> matriz[1][columna]&&matriz[2][columna]> matriz[3][columna]){
               Mayor=2;
               NombreCliente=comision[Mayor][nombre];
           }
           if(matriz[3][columna]> matriz[1][columna]&&matriz[3][columna]> matriz[2][columna]){
               Mayor=3;
               NombreCliente=comision[Mayor][nombre];
           }     
        }
         if(mes=="1"){
         System.out.println("La cantidad mas alta es de Q"+NumMayor);
         System.out.println("El nombre es "+NombreCliente);
         System.out.println("\n");
         }
         else{
         System.out.println("La mayor venta es " + mes + " de Q"+NumMayor);
         System.out.println("Su nombre es "+NombreCliente);
         System.out.println("\n");  
         }
         
         
    }
      
     //Funcion Para Sacar la Venta Menor de Cada Semana
     public static void MesTotalMenor(int columna,String mes){
       String NombreCliente="";
         int NumMenor=comision.length;

         for (int i = 1; i < comision.length-1; i++) {
             int Menor=0;
            sumafila[i][columna]=Integer.parseInt(comision[i][columna]);
            if(NumMenor > sumafila[i][columna]){
                NumMenor=sumafila[i][columna];
            }
           matriz[1][columna]=Integer.parseInt(comision[1][columna]);
           matriz[2][columna]=Integer.parseInt(comision[2][columna]);
           matriz[3][columna]=Integer.parseInt(comision[3][columna]);
            
           if(matriz[1][columna]< matriz[2][columna]&&matriz[1][columna]< matriz[3][columna]){
               Menor=1;
               NombreCliente=comision[Menor][nombre];
           }
           if(matriz[2][columna]< matriz[1][columna]&&matriz[2][columna]< matriz[3][columna]){
               Menor=2;
               NombreCliente=comision[Menor][nombre];
           }
           if(matriz[3][columna]< matriz[1][columna]&&matriz[3][columna]< matriz[2][columna]){
               Menor=3;
               NombreCliente=comision[Menor][nombre];
           }     
        }
         System.out.println("La menor venta es " + mes + " de Q"+NumMenor);
         System.out.println("Su nombre es "+NombreCliente);
         System.out.println("\n");     
         
     }
     
     //Funcion Para Modificar un Dato
     public static void Modificar(){
         Scanner lector = new  Scanner(System.in);
         int colummna=0,fila=0;
         String valor="";
         
         
         System.out.println("¿En que columna se encuentra el dato?\n"
                 + "0. Modificar nombre de la persona\n"
                 + "1. Modificar cantidad del mes de enero\n"
                 + "2. Modificar cantidad del mes de febrero\n"
                 + "3. Modificar cantidad del mes de marzo");
         colummna =lector.nextInt();
         System.out.println("¿En que fila se encuentra el dato?\n"
                 + "1. Modificar fila 1\n"
                 + "2. Modificar fila 2\n"
                 + "3. Modificar fila 3");
         fila =lector.nextInt(); 
         System.out.println("Ingresa valores nuevos");
         valor=lector.nextLine();
         valor=lector.nextLine();
          for (int i = 1; i < comision.length-1; i++) {
              comision[fila][colummna]=valor;
          }
     }
    
     //Funcion para Buscar Cantidad
     public static void Busqueda(){
        Scanner lector = new  Scanner(System.in);
        String Busqueda[]=new String[2];
        int cantbusqueda;
      
         System.out.println("Ingrese la cantidad que desea buscar");
         cantbusqueda=lector.nextInt();
         for (int i = 1; i < comision.length-1; i++) {
             
             if(Integer.parseInt(comision[i][ENERO])==cantbusqueda){
                 Busqueda[0]=comision[i][nombre];
                 Busqueda[1]="ENERO";
             }
             
             if(Integer.parseInt(comision[i][FEBRERO])==cantbusqueda){
                 Busqueda[0]=comision[i][nombre];
                 Busqueda[1]="FEBRERO";
             }
             
             if(Integer.parseInt(comision[i][MARZO])==cantbusqueda){
                 Busqueda[0]=comision[i][nombre];
                 Busqueda[1]="MARZO";
             }  
         }
             System.out.println("La persona que vendio fue " +Busqueda[0]);
             System.out.println("El mes que vendio fue  " +Busqueda[1]);
  
     }
     
     public static void main(String[] args) {
       Scanner lector = new  Scanner(System.in);
       int op=0;
       int bu=1;
       
       while(bu==1){
       System.out.println("Menu de opciones\n"
               + "1. Ingresar datos de clientes\n"
               + "2. Consultar quien hizo la menor y la mayor venta\n"
               + "3. Cosultar el nombre de la personas con mas ventas en 3 meses\n"
               + "4. Cambiar datos\n"
               + "5. Realizar busqueda\n"
               + "6. Mostrar tabla\n"
               + "7. Salir");
      op=lector.nextInt();
      
      switch(op){
          
          case 1:
              Registro();
              TotalDePromediosClientes();
              SumaGranTotal();
              System.out.println("\n");
              ImprimirMatriz(comision);
              break;
          case 2:
              MesTotalMayor(ENERO,"ENERO");
              MesTotalMayor(FEBRERO,"FEBRERO");
              MesTotalMayor(MARZO,"MARZO");
              MesTotalMenor(ENERO,"ENERO");
              MesTotalMenor(FEBRERO,"FEBRERO");
              MesTotalMenor(MARZO,"MARZO");
              break;
          case 3:
              MesTotalMayor(resultado,"1");
              break;
          case 4:
              ImprimirMatriz(comision);
              System.out.println("\n");
              Modificar();
             TotalDePromediosClientes();
              SumaGranTotal();
              System.out.println("Se ha realizado el cambio");
              break;
          case 5:
              Busqueda();
              break;
          case 6:
              ImprimirMatriz(comision);
              break;
          case 7:
              System.exit(0);
              break;
          default: 
              System.out.println("");
              break;   
      }
       System.out.println("\n");
       System.out.println("Deseas volver a repetir");
       System.out.println("Presiona el  1 - para repetir");
       System.out.println("Presiona el  0 - para salir");
       bu=lector.nextInt();
       System.out.println("\n");
       
     
        
    }
    
   }
}