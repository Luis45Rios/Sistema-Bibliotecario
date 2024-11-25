import java.util.Scanner;

public class Estudoamte6 {
    private String usuarioReserva1, usuarioReserva2, usuarioReserva3;
    private String libroReservado1, libroReservado2, libroReservado3;
    private boolean activa1, activa2, activa3;
    private Scanner scanner = new Scanner(System.in);

    public void Estudiante6() {
        usuarioReserva1 = "";
        usuarioReserva2 = "";
        usuarioReserva3 = "";
        libroReservado1 = "";
        libroReservado2 = "";
        libroReservado3 = "";
        activa1 = false;
        activa2 = false;
        activa3 = false;
    }

    public boolean crearReserva(String nombreUsuario, String nombreLibro) {
        if (usuarioReserva1.trim().isEmpty() && libroReservado1.trim().isEmpty()) {
            System.out.println("Error: Ingresa los datos correspondientes...");
        } else {
            if (usuarioReserva1 == "" && libroReservado1 == "") {
                usuarioReserva1 = nombreUsuario;
                usuarioReserva1 = nombreLibro;
                activa1 = true;
                return true;
            } else if (usuarioReserva2.equals("")) {
                usuarioReserva2 = nombreUsuario;
                libroReservado2 = nombreLibro;
                activa2 = true;
                return true;
            } else if (usuarioReserva3.equals("")) {
                usuarioReserva3 = nombreUsuario;
                libroReservado3 = nombreLibro;
                activa3 = true;
                return true;
            }
        }
                return activa1;
    }
}
