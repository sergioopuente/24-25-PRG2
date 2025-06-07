import java.util.Scanner;

public class EscalaMayor {
    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int TONO = 2;
    static final int SEMITONO = 1;
    static final int[] PATRON_MAYOR = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};

    public static void main(String[] args) {
        int notaBase = obtenerNotaBase();
        String[] escala = construirEscala(notaBase);
        String[] acorde = {escala[0], escala[2], escala[4]};

        System.out.println("Ha elegido la nota " + NOTAS[notaBase]);
        System.out.println("La escala de " + NOTAS[notaBase] + " Mayor es: " + formatear(escala));
        System.out.println("El acorde de " + NOTAS[notaBase] + " Mayor esta conformado por: " + formatear(acorde));
    }

    static int obtenerNotaBase() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        int opcion = sc.nextInt() - 1;
        if (opcion < 0 || opcion >= NOTAS.length) {
            opcion = 0;
        }
        return opcion;
    }

    static String[] construirEscala(int notaBase) {
        String[] escala = new String[PATRON_MAYOR.length + 1];
        escala[0] = NOTAS[notaBase];
        int posicion = notaBase;
        for (int i = 0; i < PATRON_MAYOR.length; i++) {
            posicion = (posicion + PATRON_MAYOR[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[posicion];
        }
        return escala;
    }

    static String formatear(String[] notas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notas.length; i++) {
            sb.append("[").append(notas[i]).append("]");
            if (i < notas.length - 1) {
                sb.append(" / ");
            }
        }
        return sb.toString();
    }
}
