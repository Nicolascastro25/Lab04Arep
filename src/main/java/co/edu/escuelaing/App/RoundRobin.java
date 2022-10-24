/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package co.edu.escuelaing.App;

/**
 *
 * @author jaime.cacuna
 */
public class RoundRobin {

    private static final Object object = new Object();
    private static int[] puertos = new int[]{35001, 35002, 35003};
    private static int turno = puertos.length;
    private static int turnoActual = -1;

    public static void serviceRoundRobin(int[] puertos) {
        synchronized (object) {
            turnoActual = -1;
        }
    }

    public static int obtenerSiguiente() {
        synchronized (object) {
            if (turnoActual == turno - 1) {
                turnoActual = 0;
            } else {
                turnoActual += 1;
            }
        }
        return puertos[turnoActual];
    }
}
