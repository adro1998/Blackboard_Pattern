package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Enviroment {

    /**
     * En el tablero:
     * 0 -> no hay nada
     * 1 -> posicion del robot
     * 2 -> obstaculo
     * 3 -> objetivo
     *
     * Tablero 5x5
     *      0  1  2  3  4
     *  0 [[0, 0, 0, 0, 0],
     *  1  [0, 0, 0, 0, 0],
     *  2  [0, 0, 0, 0, 0],
     *  3  [0, 0, 0, 0, 0],
     *  4  [0, 0, 0, 0, 0]]
     *  i = filas
     *  j = columnas
     */
    public  Integer[][] tablero = new Integer[5][5];
    public  Integer[] objetivoij = new Integer[2];
    public  Integer[] ubicaRobot =  new Integer[2];

    public Enviroment(){
        Scanner input = new Scanner(System.in);
        //
        System.out.println("Ingrese ubicación del objetivo [i][j]");
        System.out.print("i = ");
        objetivoij[0] = input.nextInt();
        System.out.print("j = ");
        objetivoij[1] =input.nextInt();
        //
        ubicaRobot[0] = 0;
        ubicaRobot[1] = 0;
        //
    }

    public void mostrar_tablero (){
        actualizar_tablero();
        System.out.println("------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    private void actualizar_tablero (){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(tablero[i][j] == null || tablero[i][j] != 2) {
                    tablero[i][j] = 0;
                }
            }
        }
        //
        tablero[ubicaRobot[0]][ubicaRobot[1]] = 1;
        tablero[objetivoij[0]][objetivoij[1]] = 3;
    }
}
