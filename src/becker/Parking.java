
/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

import becker.robots.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
/**
 *
 * @author santi
 */
public class Parking {

    public static void sacarcarro(Robot karel, String placa, String zona,Carros carro){
        int x=0;
        switch(zona)
        {
            case "1":{
                IrParking1(karel);
                for (int i = 0; i < 5; i++) {
  
               karel.move();
               karel.pickThing();
                }
                break;
            }
            case "2":
            {
                IrParking2(karel);
                for (int i = 0; i < 5; i++) {
  
               karel.move();
    
                }
                break;
            }
            case "3":{
                IrParking3(karel);
                for (int i = 0; i < 5; i++) {
  
               karel.move();
               karel.pickThing(carro.obj);
                }
                break;
            }
        }
    }
        public static void girarderecha(Robot karel){
        for (int j=0; j<3; j++){
            karel.turnLeft();
        }
    }
                    public static void revisarzona(Robot karel){
                        int x=0;
        do{
            karel.move();
            if(karel.canPickThing()){
                x++;
            }
        }
        while(karel.frontIsClear()==true);
        girar180(karel);
                        for (int i = 0; i < x; i++) {
                                karel.move();
                            }
                                karel.putThing();
                                volvercarril(karel);
                    }
               
                        public static int menu(){
    int opcion=0; 
    String op="";
    op=JOptionPane.showInputDialog("SELECCIONE UNA OPCION= \n"
            + "1. Ingresar un vehiculo\n"
            + "2.Sacar un vehiculo\n"
            + "3.mostrar vehiculos de una seccion\n"
            + "4.Generar reporte de ingresos");
    opcion=Integer.parseInt(op);
 return opcion;
    }
                             public static int review(Robot karel){
     int cont1=0; int cont2=0; int cont3=0; int numero=0;
     IrParking1(karel);
     do{
         karel.move();
     }
     while(karel.frontIsClear());
     girar180(karel);
     for (int i = 0; i < 5; i++) {
         if(karel.canPickThing()){
             cont1++;
             }
         karel.move();
     }
     karel.move();
     VolverParking1(karel);
     IrParking2(karel);
     do{
         karel.move();
     }
     while(karel.frontIsClear());
     girar180(karel);
     for (int i = 0; i < 5; i++) {
         if(karel.canPickThing()){
             cont2++;
             }
         karel.move();
     }
     karel.move();
     VolverParking2(karel);   
      IrParking3(karel);
     do{
         karel.move();
     }
     while(karel.frontIsClear());
     girar180(karel);
     for (int i = 0; i < 5; i++) {
         if(karel.canPickThing()){
             cont3++;
             }
         karel.move();
     }
     karel.move();
     VolverParking3(karel);
     if((cont1<cont2)&&(cont2<cont3)){
         numero=1;
     }
     else if((cont2<cont1)&&(cont1<cont3)){
        numero=2;
     }
     else if((cont3<cont2)&&(cont2<cont1)){
         numero= 3;
     }
     else if((cont1==cont2)&&(cont2<cont3)){
         numero = (int) (Math.random() * 2) + 1;
     }
     else if((cont1==cont2)&&(cont2>cont3)){
         numero = 3;
     }
     else if((cont2==cont3)&&(cont3<cont1)){
      numero = (int) (Math.random() * 3) + 2;
     }  
     else if((cont2==cont3)&&(cont3>cont1)){
      numero = 1;
     }
     else if((cont1==cont3)&&(cont1<cont2)){
      //función para elegir entre 1 y 3 si son iguales
     }  
     else if((cont1==cont3)&&(cont1>cont2)){
      numero = 2;
     }
      else if((cont1==cont3)&&(cont1==cont2)){
      //función para elegir si todas son iguales
     }
     return numero;
 }
                                public static void Ingresarcarro(City parking,int xinicial,int yinicial, Robot karel){
                                        int result;
        String placa=JOptionPane.showInputDialog(null,"placa");
                Thing obj= new Thing(parking,xinicial,yinicial,Direction.EAST);
                Calendar calendario = new GregorianCalendar();
                int hora =calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                Carros carro= new Carros(placa,obj);
                
                karel.pickThing();
                result=review(karel);
                if(result==1){
                IrParking1(karel);
                
                revisarzona(karel);
                JOptionPane.showMessageDialog(null,"CARRO REGISTRADO EN LA ZONA: "+result+" A LAS: "+hora+":"+minutos);
                }
                else if(result==2){
                 IrParking2(karel);
                
                revisarzona(karel);
               JOptionPane.showMessageDialog(null,"CARRO REGISTRADO EN LA ZONA: "+result+" A LAS: "+hora+":"+minutos);
                }
                else if(result==3){
                 IrParking3(karel);
                
                revisarzona(karel);
                JOptionPane.showMessageDialog(null,"CARRO REGISTRADO EN LA ZONA: "+result+" A LAS: "+hora+":"+minutos);
                }
    }

    public static void volvercarril(Robot karel){
        int x=-2;
        do{
            karel.move();
        }
        while(karel.getStreet()!=x);
    }
        public static void girar180(Robot karel){
        for (int j=0; j<2; j++){
            karel.turnLeft();
        }
    }
             public static void IrParking1(Robot karel){
        for (int i=0; i<16; i++){
            karel.move();
        }
        for (int j=0; j<3; j++){
            karel.turnLeft();
        }
        karel.move();
        karel.move();
    }
                public static void IrParking2(Robot karel){
        for (int i=0; i<12; i++){
            karel.move();
        }
        for (int j=0; j<3; j++){
            karel.turnLeft();
        }
        karel.move();
        karel.move();
    }
                    public static void IrParking3(Robot karel){
        for (int i=0; i<8; i++){
            karel.move();
        }
        for (int j=0; j<3; j++){
            karel.turnLeft();
        }
        karel.move();
        karel.move();
    }
                        public static void VolverParking1(Robot karel){

        karel.turnLeft();
        for (int i=0; i<16; i++){
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
    }
                            public static void VolverParking2(Robot karel){

        karel.turnLeft();
        for (int i=0; i<12; i++){
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
    }
                                public static void VolverParking3(Robot karel){

        karel.turnLeft();
        for (int i=0; i<8; i++){
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
    }
    
                                public static void dejarZonaTemp(Robot karel){
            
        for (int i=0; i<5; i++){
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        if(karel.canPickThing()){
            karel.move();
            if(karel.canPickThing()){
                karel.move();
                if(karel.canPickThing()){
                    karel.putThing();
                }
                else { karel.putThing();
                karel.move();
                }
            }
            else { karel.putThing();
            karel.move();
            karel.move();}                   
                                }
        else { karel.putThing();
        karel.move();
        karel.move();
        karel.move();}
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
        
    }
                                
                                public static void cogerZonaTemp(Robot karel){
            
        for (int i=0; i<5; i++){
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        if(karel.canPickThing()){
        karel.pickThing();
        karel.move();
        karel.move();
        karel.move();
        }
        else{karel.move();
        if(karel.canPickThing()){
        karel.pickThing();
        karel.move();
        karel.move();}
        else{karel.move();
        if(karel.canPickThing()){
        karel.pickThing();
        karel.move();
        }
        else{karel.move();
        if(karel.canPickThing()){
        karel.pickThing();
        }}}}
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
                                }
    
    public static void main(String[] args){
                int xinicial=-2; int yinicial=18;
        City parking = new City();
        Robot karel = new Robot(parking, -2, 18, Direction.WEST,1);
        //parqueadero 1
        Wall w1 = new Wall(parking, -1,1, Direction.WEST);
        Wall w2 = new Wall(parking, -2,1, Direction.WEST);
        Wall w3 = new Wall(parking, -3,1, Direction.WEST);
        Wall w4 = new Wall(parking, -4,1, Direction.WEST);
        Wall w5 = new Wall(parking, -5,1, Direction.WEST);
        Wall w6 = new Wall(parking, -6,1, Direction.WEST);
        Wall w7 = new Wall(parking, -7,1, Direction.WEST);
        Wall w8 = new Wall(parking, -8,1, Direction.NORTH);
        Wall w36 = new Wall(parking, -8,1, Direction.WEST);
        //paredes abajo
        Wall w9 = new Wall(parking, -1,1, Direction.SOUTH);
        Wall w10 = new Wall(parking, -1,2, Direction.SOUTH);
        Wall w11 = new Wall(parking, -1,3, Direction.SOUTH);
        Wall w12 = new Wall(parking, -1,4, Direction.SOUTH);
        Wall w13 = new Wall(parking, -1,5, Direction.SOUTH);
        Wall w14 = new Wall(parking, -1,6, Direction.SOUTH);
        Wall w15 = new Wall(parking, -1,7, Direction.SOUTH);
        Wall w16 = new Wall(parking, -1,8, Direction.SOUTH);
        Wall w17 = new Wall(parking, -1,9, Direction.SOUTH);
        Wall w18 = new Wall(parking, -1,10, Direction.SOUTH);
        Wall w19 = new Wall(parking, -1,11, Direction.SOUTH);
        Wall w20 = new Wall(parking, -1,12, Direction.SOUTH);
        Wall w21 = new Wall(parking, -1,13, Direction.SOUTH);
        Wall w22 = new Wall(parking, -1,14, Direction.SOUTH);
        Wall w23 = new Wall(parking, -1,15, Direction.SOUTH);
        Wall w24 = new Wall(parking, -1,16, Direction.SOUTH);
        Wall w25 = new Wall(parking, -1,17, Direction.SOUTH);
        Wall w26 = new Wall(parking, -1,18, Direction.SOUTH);
        //Parqueadero uno P2
        Wall w27 = new Wall(parking, -8,2, Direction.NORTH);
        Wall w28 = new Wall(parking, -8,3, Direction.NORTH);
        Wall w29 = new Wall(parking, -7,3, Direction.EAST);
        Wall w30 = new Wall(parking, -6,3, Direction.EAST);
        Wall w31 = new Wall(parking, -5,3, Direction.EAST);
        Wall w32 = new Wall(parking, -4,3, Direction.EAST);
        Wall w33 = new Wall(parking, -8,3, Direction.EAST);
        Wall w34 = new Wall(parking, -4,1, Direction.SOUTH);
        Wall w35 = new Wall(parking, -4,3, Direction.SOUTH);
        //parqueadero 2
        Wall w37 = new Wall(parking, -8,5, Direction.WEST);
        Wall w39 = new Wall(parking, -4,5, Direction.WEST);
        Wall w40 = new Wall(parking, -5,5, Direction.WEST);
        Wall w41 = new Wall(parking, -6,5, Direction.WEST);
        Wall w42 = new Wall(parking, -7,5, Direction.WEST);
        Wall w43 = new Wall(parking, -8,5, Direction.NORTH);
        Wall w44 = new Wall(parking, -8,6, Direction.NORTH);
        Wall w45 = new Wall(parking, -8,7, Direction.NORTH);
        Wall w46 = new Wall(parking, -7,7, Direction.EAST);
        Wall w47 = new Wall(parking, -6,7, Direction.EAST);
        Wall w48 = new Wall(parking, -5,7, Direction.EAST);
        Wall w49 = new Wall(parking, -4,7, Direction.EAST);
        Wall w50 = new Wall(parking, -8,7, Direction.EAST);
        Wall w51 = new Wall(parking, -4,5, Direction.SOUTH);
        Wall w52 = new Wall(parking, -4,7, Direction.SOUTH);
        //parqueadero 3
        Wall w53 = new Wall(parking, -8,9, Direction.WEST);
        Wall w54 = new Wall(parking, -4,9, Direction.WEST);
        Wall w55 = new Wall(parking, -5,9, Direction.WEST);
        Wall w56 = new Wall(parking, -6,9, Direction.WEST);
        Wall w57 = new Wall(parking, -7,9, Direction.WEST);
        Wall w58 = new Wall(parking, -8,9, Direction.NORTH);
        Wall w59 = new Wall(parking, -8,10, Direction.NORTH);
        Wall w60 = new Wall(parking, -8,11, Direction.NORTH);
        Wall w61 = new Wall(parking, -7,11, Direction.EAST);
        Wall w62 = new Wall(parking, -6,11, Direction.EAST);
        Wall w63 = new Wall(parking, -5,11, Direction.EAST);
        Wall w64 = new Wall(parking, -4,11, Direction.EAST);
        Wall w65 = new Wall(parking, -8,11, Direction.EAST);
        Wall w66 = new Wall(parking, -4,9, Direction.SOUTH);
        Wall w67 = new Wall(parking, -4,11, Direction.SOUTH);
        //Zona temporal
        Wall w68 = new Wall(parking, -4,4, Direction.SOUTH);
        Wall w69 = new Wall(parking, -4,8, Direction.SOUTH);
        Wall w70 = new Wall(parking, -4,12, Direction.SOUTH);
        Wall w71 = new Wall(parking, -5,13, Direction.WEST);
        Wall w72 = new Wall(parking, -5,13, Direction.NORTH);
        Wall w73 = new Wall(parking, -5,13, Direction.NORTH);
        Wall w74 = new Wall(parking, -4,13, Direction.WEST);
        Wall w75 = new Wall(parking, -5,14, Direction.NORTH);
        Wall w76 = new Wall(parking, -5,15, Direction.NORTH);
        Wall w77 = new Wall(parking, -5,16, Direction.NORTH);
        Wall w78 = new Wall(parking, -5,16, Direction.NORTH);
        Wall w79 = new Wall(parking, -5,16, Direction.EAST);
        Wall w80 = new Wall(parking, -4,16, Direction.EAST);
        Wall w81 = new Wall(parking, -4,17, Direction.SOUTH);
        Wall w82 = new Wall(parking, -4,18, Direction.SOUTH);
        Wall w83 = new Wall(parking, -3,18, Direction.EAST);
        Wall w84 = new Wall(parking, -1,18, Direction.EAST);
        Thing cosa=new Thing(parking,-8,2,Direction.EAST);
        Thing cosa1=new Thing(parking,-7,2,Direction.EAST);
        Thing cosa2=new Thing(parking,-6,2,Direction.EAST);
        Thing cosa3=new Thing(parking,-8,6,Direction.EAST);
        Thing cosa4=new Thing(parking,-7,6,Direction.EAST);
        Thing cosa5=new Thing(parking,-7,10,Direction.EAST);
        Thing cosa6=new Thing(parking,-8,10,Direction.EAST);
        
        int opcion= menu();
           switch(opcion){
        case 1:{
            Ingresarcarro(parking, xinicial,yinicial,karel);
            break;
        }
        case 2:{
            String placa=JOptionPane.showInputDialog(null,"placa");
            Carros carro= new Carros(placa,cosa);
            String zona=JOptionPane.showInputDialog(null, "zona");
           sacarcarro(karel,placa,zona,carro);
            
            break;
        }
        case 3:{
            break;
        }
        
           }
    }
    
}

