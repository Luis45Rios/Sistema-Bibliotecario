public class App {
    public static void main(String[] args) throws Exception {
        // Crear instancias de todas las clases
        Estudiante1 gestorLibros = new Estudiante1();
        Estudiante2 gestorPrestamos = new Estudiante2();
        Estudiante3 gestorUsuarios = new Estudiante3();
        Estudiante4 gestorMultas = new Estudiante4();
        Estudiante5 gestorEstadisticas = new Estudiante5();
        Estudiante6 gestorReservas = new Estudiante6();
        
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        while (opcion != 7) {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    gestionarLibros(scanner, gestorLibros);
                    break;
                case 2:
                    gestionarPrestamos(scanner, gestorLibros, gestorPrestamos, gestorUsuarios, gestorEstadisticas);
                    break;
                case 3:
                    gestionarUsuarios(scanner, gestorUsuarios);
                    break;
                case 4:
                    gestionarMultas(scanner, gestorMultas, gestorEstadisticas);
                    break;
                case 5:
                    gestionarEstadisticas(gestorEstadisticas);
                    break;
                case 6:
                    gestionarReservas(scanner, gestorReservas, gestorLibros);
                    break;
                case 7:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }
    
    // Función para mostrar el menú principal
    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1. Gestión de Libros");
        System.out.println("2. Gestión de Préstamos");
        System.out.println("3. Gestión de Usuarios");
        System.out.println("4. Gestión de Multas");
        System.out.println("5. Ver Estadísticas");
        System.out.println("6. Gestión de Reservas");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Función para gestionar libros
    private static void gestionarLibros(Scanner scanner, Estudiante1 gestorLibros) {
        System.out.println("\n=== GESTIÓN DE LIBROS ===");
        System.out.println("1. Mostrar inventario");
        System.out.println("2. Verificar disponibilidad de un libro");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                gestorLibros.mostrarInventario();
                break;
            case 2:
                System.out.print("Ingrese el nombre del libro: ");
                String libro = scanner.nextLine();
                boolean disponible = gestorLibros.verificarDisponibilidad(libro);
                System.out.println(disponible ? "El libro está disponible" : "El libro no está disponible");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    
    // Función para gestionar préstamos
    private static void gestionarPrestamos(Scanner scanner, Estudiante1 gestorLibros, 
            Estudiante2 gestorPrestamos, Estudiante3 gestorUsuarios, Estudiante5 gestorEstadisticas) {
        System.out.println("\n=== GESTIÓN DE PRÉSTAMOS ===");
        System.out.println("1. Registrar préstamo");
        System.out.println("2. Registrar devolución");
        System.out.println("3. Ver préstamos activos");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del usuario: ");
                String usuario = scanner.nextLine();
                System.out.print("Ingrese el nombre del libro: ");
                String libro = scanner.nextLine();
                
                if (gestorUsuarios.verificarUsuario(usuario) && gestorLibros.verificarDisponibilidad(libro)) {
                    if (gestorPrestamos.registrarPrestamo(usuario, libro)) {
                        gestorLibros.registrarPrestamo(libro);
                        gestorEstadisticas.registrarPrestamo(libro);
                        System.out.println("Préstamo registrado con éxito");
                    } else {
                        System.out.println("No se pudo registrar el préstamo");
                    }
                } else {
                    System.out.println("Usuario no válido o libro no disponible");
                }
                break;
                
            case 2:
                System.out.print("Ingrese el nombre del usuario: ");
                usuario = scanner.nextLine();
                System.out.print("Ingrese el nombre del libro: ");
                libro = scanner.nextLine();
                
                if (gestorPrestamos.registrarDevolucion(usuario, libro)) {
                    gestorLibros.registrarDevolucion(libro);
                    System.out.println("Devolución registrada con éxito");
                } else {
                    System.out.println("No se encontró el préstamo");
                }
                break;
                
            case 3:
                gestorPrestamos.mostrarPrestamos();
                break;
                
            default:
                System.out.println("Opción inválida");
        }
    }
    
    // Función para gestionar usuarios
    private static void gestionarUsuarios(Scanner scanner, Estudiante3 gestorUsuarios) {
        System.out.println("\n=== GESTIÓN DE USUARIOS ===");
        System.out.println("1. Registrar nuevo usuario");
        System.out.println("2. Ver lista de usuarios");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del nuevo usuario: ");
                String nuevoUsuario = scanner.nextLine();
                if (gestorUsuarios.registrarUsuario(nuevoUsuario)) {
                    System.out.println("Usuario registrado con éxito");
                } else {
                    System.out.println("No se pudo registrar el usuario");
                }
                break;
            case 2:
                gestorUsuarios.mostrarUsuarios();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    
    // Función para gestionar multas
    private static void gestionarMultas(Scanner scanner, Estudiante4 gestorMultas, Estudiante5 gestorEstadisticas) {
        System.out.println("\n=== GESTIÓN DE MULTAS ===");
        System.out.println("1. Registrar multa");
        System.out.println("2. Pagar multa");
        System.out.println("3. Ver multas pendientes");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del usuario: ");
                String usuario = scanner.nextLine();
                System.out.print("Ingrese los días de retraso: ");
                int dias = scanner.nextInt();
                
                if (gestorMultas.registrarMulta(usuario, dias)) {
                    gestorEstadisticas.registrarMulta(dias * 1000);
                    System.out.println("Multa registrada con éxito");
                } else {
                    System.out.println("No se pudo registrar la multa");
                }
                break;
                
            case 2:
                System.out.print("Ingrese el nombre del usuario: ");
                usuario = scanner.nextLine();
                if (gestorMultas.pagarMulta(usuario)) {
                    System.out.println("Multa pagada con éxito");
                } else {
                    System.out.println("No se encontró la multa");
                }
                break;
                
            case 3:
                gestorMultas.mostrarMultas();
                break;
                
            default:
                System.out.println("Opción inválida");
        }
    }
    
    // Función para gestionar estadísticas
    private static void gestionarEstadisticas(Estudiante5 gestorEstadisticas) {
        gestorEstadisticas.mostrarLibroMasPrestado();
        gestorEstadisticas.mostrarEstadisticas();
    }
    
    // Función para gestionar reservas
    private static void gestionarReservas(Scanner scanner, Estudiante6 gestorReservas, Estudiante1 gestorLibros) {
        System.out.println("\n=== GESTIÓN DE RESERVAS ===");
        System.out.println("1. Crear reserva");
        System.out.println("2. Cancelar reserva");
        System.out.println("3. Ver reservas activas");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del usuario: ");
                String usuario = scanner.nextLine();
                System.out.print("Ingrese el nombre del libro: ");
                String libro = scanner.nextLine();
                
                if (!gestorLibros.verificarDisponibilidad(libro)) {
                    if (gestorReservas.crearReserva(usuario, libro)) {
                        System.out.println("Reserva creada con éxito");
                    } else {
                        System.out.println("No se pudo crear la reserva");
                    }
                } else {
                    System.out.println("El libro está disponible, puede tomarlo prestado");
                }
                break;
                
            case 2:
                System.out.print("Ingrese el nombre del usuario: ");
                usuario = scanner.nextLine();
                System.out.print("Ingrese el nombre del libro: ");
                libro = scanner.nextLine();
                
                if (gestorReservas.cancelarReserva(usuario, libro)) {
                    System.out.println("Reserva cancelada con éxito");
                } else {
                    System.out.println("No se encontró la reserva");
                }
                break;
                
            case 3:
                gestorReservas.mostrarReservas();
                break;
                
            default:
                System.out.println("Opción inválida");
        }
    }
}