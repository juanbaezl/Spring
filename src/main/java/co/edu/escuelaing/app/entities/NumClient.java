package co.edu.escuelaing.app.entities;

public class NumClient {
    public static void main(String[] args) {
        Numero juego = Numero.getInstance();
        juego.newNum();
        System.out.println(juego.getNum());
        String ent, res;
        while (!(ent = System.console().readLine()).equals("exit")) {
            res = juego.comparacion(ent);
            System.out.println(res);
            if (res.startsWith("Has Ganado!"))
                break;
        }
    }
}
