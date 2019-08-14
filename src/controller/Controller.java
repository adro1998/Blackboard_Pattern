package controller;

import app.Main;
import sourceknowledges.LearningEnviroment;
import sourceknowledges.Move;

public class Controller {
    public void iniciar_recorrido() {
        LearningEnviroment learningEnviroment = new LearningEnviroment();
        Move move = new Move();
        while (!learningEnviroment.llego()){
            Main.enviroment.mostrar_tablero();
            learningEnviroment.ver();
            Main.enviroment.mostrar_tablero();
            move.move();
            Main.enviroment.mostrar_tablero();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
