package sourceknowledges;


import app.Enviroment;
import app.Main;

import java.util.ArrayList;
import java.util.Collections;

public class Move {



    public void move(){
        ArrayList<Integer>  arreglo  = new ArrayList<Integer>();
        Integer posicion_sig1 = null;
        Integer posicion_sig2 = null;
        Integer posicion_sig3 = null;
        Integer posicion_sig4 = null;
        if (ubicacion_posible(Main.enviroment.ubicaRobot[0]-1, Main.enviroment.ubicaRobot[1])) {
            posicion_sig1 = Math.abs(Main.enviroment.ubicaRobot[0]-1-Main.enviroment.objetivoij[0])+Math.abs(Main.enviroment.ubicaRobot[1]-Main.enviroment.objetivoij[1]);
        }
        if(ubicacion_posible(Main.enviroment.ubicaRobot[0], Main.enviroment.ubicaRobot[1]-1)){
            posicion_sig2 = Math.abs(Main.enviroment.ubicaRobot[0]-Main.enviroment.objetivoij[0])+Math.abs(Main.enviroment.ubicaRobot[1]-1-Main.enviroment.objetivoij[1]);
        }
        if(ubicacion_posible(Main.enviroment.ubicaRobot[0], Main.enviroment.ubicaRobot[1]+1)){
            posicion_sig3 = Math.abs(Main.enviroment.ubicaRobot[0]-Main.enviroment.objetivoij[0])+Math.abs(Main.enviroment.ubicaRobot[1]+1-Main.enviroment.objetivoij[1]);
        }
        if(ubicacion_posible(Main.enviroment.ubicaRobot[0]+1, Main.enviroment.ubicaRobot[1])){
            posicion_sig4 = Math.abs(Main.enviroment.ubicaRobot[0]+1-Main.enviroment.objetivoij[0])+Math.abs(Main.enviroment.ubicaRobot[1]-Main.enviroment.objetivoij[1]);
        }

        if(posicion_sig1 != null){
            arreglo.add(posicion_sig1);
        }
        if(posicion_sig2 != null){
            arreglo.add(posicion_sig2);
        }
        if(posicion_sig3 != null){
            arreglo.add(posicion_sig3);
        }
        if(posicion_sig4 != null){
            arreglo.add(posicion_sig4);
        }

        Collections.sort(arreglo);

        if(arreglo.get(0).equals(posicion_sig1)){
            move_up();
        }else if(arreglo.get(0).equals(posicion_sig2)){
            move_right();
        }
        else if(arreglo.get(0).equals(posicion_sig3)){
            move_left();
        }
        else if(arreglo.get(0).equals(posicion_sig4)){
            move_down();
        }
    }
    public void move_up(){
        Main.enviroment.ubicaRobot[0] = Main.enviroment.ubicaRobot[0] - 1;
    }
    public void move_left(){
        Main.enviroment.ubicaRobot[1] = Main.enviroment.ubicaRobot[1] + 1;
    }
    public void move_right(){
        Main.enviroment.ubicaRobot[1] = Main.enviroment.ubicaRobot[1] - 1;
    }
    public void move_down(){
        Main.enviroment.ubicaRobot[0] = Main.enviroment.ubicaRobot[0] + 1;
    }

    public static boolean ubicacion_posible(int coordi, int coordj){
        Integer[][] tableroAux = new Integer[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tableroAux[i][j] = 0;
            }
        }
        try{
            tableroAux[coordi][coordj] = 1;
            if(Main.enviroment.tablero[coordi][coordj]==2){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
