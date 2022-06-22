package co.edu.escuelaing.app.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numero {

    // Singleton numero
    private static Numero _instance = new Numero();

    // Numero de Juego
    private ArrayList<Integer> num;

    // Intentos
    private int intentos;

    /**
     * Metodo que devuelve la instancia del numero
     * 
     * @return
     */
    public static Numero getInstance() {
        return _instance;
    }

    /**
     * Metodo que genera un nuevo numero aleatorio
     * 
     * @return
     */
    public void newNum() {
        this.intentos = 0;
        this.num = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            this.num.add((int) (Math.random() * 10));
        }
    }

    public ArrayList<Integer> getNum() {
        return this.num;
    }

    /**
     * Metodo que compara el numero con un string entrante
     * 
     * @param entrante string a comparar
     * @return
     */
    public String comparacion(String entrante) {
        intentos++;
        ArrayList<Integer> copy = new ArrayList<Integer>(num);
        List<String> entList = Arrays.asList(entrante.split(""));
        int picas = 0, famas = 0;
        for (int i = 0; i < entList.size(); i++) {
            int numero = Integer.parseInt(entList.get(i));
            if (numero == copy.get(i - picas - famas)) {
                copy.remove(i - picas - famas);
                famas++;
            }
        }
        for (int i = 0; i < entList.size(); i++) {
            int numero = Integer.parseInt(entList.get(i));
            if (copy.contains(numero)) {
                copy.remove(copy.indexOf(numero));
                picas++;
            }
        }
        return famas == 4 ? String.format("Has Ganado! \nEn %1$s intentos.", intentos)
                : String.format("Picas: %1$s \nFamas: %2$s", picas, famas);
    }

    public int getIntentos() {
        return this.intentos;
    }
}
