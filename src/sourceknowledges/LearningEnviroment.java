package sourceknowledges;

import app.Main;

import java.util.Scanner;

public class LearningEnviroment {


    public void ver(){
        Scanner input = new Scanner(System.in);
        int nroObstaculos = 0;
        int posicion = 0;

        System.out.println("Ingrese número de obstaculos alrededor del robot (min:0|max:4; si no se ingresa un número de obstaculos valido se tomara como 0)");
        System.out.print("Nro. Obstaculos = ");
        nroObstaculos = input.nextInt();
        //
        if (nroObstaculos!=0 && nroObstaculos<5 && nroObstaculos>=0) {
            System.out.println("|---------|");
            System.out.println("|    1    |");
            System.out.println("|2   R   3|");
            System.out.println("|    4    |");
            System.out.println("|---------|");
            System.out.println("Ingrese las posiciones de acuerdo al mapa mostrado donde R es el robot");
            for (int i = 0; i < nroObstaculos; i++) {
                posicion = input.nextInt();
                if(Main.enviroment.ubicaRobot[0] == 0 && posicion==1){
                    System.out.println("Ubicación invalida");
                    i = i-1;
                }else if(Main.enviroment.ubicaRobot[1] == 0 && posicion==2){
                    System.out.println("Ubicación invalida");
                    i = i-1;
                }else if(Main.enviroment.ubicaRobot[0] == 4 && posicion==4){
                    System.out.println("Ubicación invalida");
                    i = i-1;
                }else if(Main.enviroment.ubicaRobot[1] == 4 && posicion==3) {
                    System.out.println("Ubicación invalida");
                    i = i - 1;
                }else if(posicion!=1 && posicion!=2 && posicion!=3 && posicion!=4){
                    System.out.println("Ubicación invalida");
                    i = i - 1;
                }else{
                    update_enviroment(posicion);
                }


            }
        }
    }

    public void update_enviroment(int posicion){
        if (posicion == 1) {
            Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]-1][Main.enviroment.ubicaRobot[1]] = 2;
        }
        else if(posicion == 2){
            Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]][Main.enviroment.ubicaRobot[1]-1] = 2;
        }
        else if(posicion == 3){
            Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]][Main.enviroment.ubicaRobot[1]+1] = 2;
        }
        else if(posicion == 4){
            Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]+1][Main.enviroment.ubicaRobot[1]] = 2;
        }
    }

    public boolean llego(){
        if (Move.ubicacion_posible(Main.enviroment.ubicaRobot[0]-1,Main.enviroment.ubicaRobot[1]) && Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]-1][Main.enviroment.ubicaRobot[1]] == 3){
            System.out.println("¡¡El robot ha llegado al destino!!");
            return true;
        }
        if (Move.ubicacion_posible(Main.enviroment.ubicaRobot[0],Main.enviroment.ubicaRobot[1]-1) && Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]][Main.enviroment.ubicaRobot[1]-1] == 3){
            System.out.println("¡¡El robot ha llegado al destino!!");
            return true;
        }
        if (Move.ubicacion_posible(Main.enviroment.ubicaRobot[0],Main.enviroment.ubicaRobot[1]+1) && Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]][Main.enviroment.ubicaRobot[1]+1] == 3){
            System.out.println("¡¡El robot ha llegado al destino!!");
            return true;
        }
        if (Move.ubicacion_posible(Main.enviroment.ubicaRobot[0]+1,Main.enviroment.ubicaRobot[1]) && Main.enviroment.tablero[Main.enviroment.ubicaRobot[0]+1][Main.enviroment.ubicaRobot[1]] == 3){
            System.out.println("¡¡El robot ha llegado al destino!!");
            return true;
        }
         return false;

    }
}
