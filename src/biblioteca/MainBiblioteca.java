package biblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {

        // ============================================
        // 1. INSTANCIACIÓN - combinando ambos constructores
        // ============================================

        // Constructor de conveniencia: arranca con 1 copia y $15000.0
        // new Libro(); // no compila: al declarar constructores propios,
        //               // el constructor sin argumentos que regalaba el compilador ya no existe.
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");

        // Constructor canónico: controlamos todos los valores
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo",
                "9781234567897", 3, 22000.0);

        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez",
                "9780307474728", 2, 18500.0);

        // ============================================
        // 2. RECHAZO #1 - Dato inválido en el constructor
        // ============================================
        Libro libroInvalido = new Libro("", "Anónimo", "0000000000", 2, 10000.0);
        System.out.println("Título guardado (debería ser \"Sin título\"): "
                + libroInvalido.getTitulo());
        System.out.println();

        // ============================================
        // 3. RECHAZO #2 - Precio inválido vía setter validado
        // ============================================
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado
                + " (se mantiene el precio anterior: $"
                + libro1.getPrecioReposicion() + ")");
        System.out.println();

        // ============================================
        // 4. FICHAS DE CADA LIBRO
        // ============================================
        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        // ============================================
        // 5. AGOTAR COPIAS DE libro1 Y PROBAR PRÉSTAMO DE MÁS
        // ============================================
        System.out.println("\n--- Prestando libro1 hasta agotar ---");
        System.out.println("¿Préstamo aceptado? " + libro1.prestar()); // 1 -> 0
        System.out.println("¿Préstamo aceptado? " + libro1.prestar()); // error, false

        // Verificamos que NO quedó en negativo
        System.out.println("Copias de libro1 (debe ser 0, nunca negativo): "
                + libro1.getCopiasDisponibles());

        // ============================================
        // 6. DEVOLUCIÓN
        // ============================================
        System.out.println("\n--- Devolviendo libro1 ---");
        libro1.devolver(); // 0 -> 1

        // ============================================
        // 7. PRECIO VÁLIDO EN libro1
        // ============================================
        System.out.println();
        boolean aceptadoOk = libro1.setPrecioReposicion(18000.0);
        System.out.println("¿Se aceptó el precio 18000.0? " + aceptadoOk);
        System.out.println("Precio de reposición actualizado de \"Clean Code\": $15000.0 -> $"
                + libro1.getPrecioReposicion());
    }
}
