package app;

import controller.Controller;

public class Main {

    public static Enviroment enviroment;
    public static void main(String[] arguments){

        enviroment = new Enviroment();
        enviroment.mostrar_tablero();
        Controller controller = new Controller();
        controller.iniciar_recorrido();
    }
}
