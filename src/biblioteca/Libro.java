package biblioteca;

public class Libro {

    // ============================================
    // ATRIBUTOS - todos private (encapsulamiento)
    // Los tres primeros son final: no cambian después del constructor.
    // ============================================
    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;

    // ============================================
    // CONSTRUCTOR CANÓNICO - único lugar con validación completa
    // ============================================
    public Libro(String titulo, String autor, String isbn,
                 int copiasDisponibles, double precioReposicion) {

        // Validación del título
        if (titulo == null || titulo.isBlank()) {
            System.out.println("Título inválido, se usó \"Sin título\" por defecto.");
            this.titulo = "Sin título";
        } else {
            this.titulo = titulo;
        }

        // Validación del autor
        if (autor == null || autor.isBlank()) {
            System.out.println("Autor inválido, se usó \"Autor desconocido\" por defecto.");
            this.autor = "Autor desconocido";
        } else {
            this.autor = autor;
        }

        // Validación del ISBN
        if (isbn == null || isbn.isBlank()) {
            System.out.println("ISBN inválido, se usó \"ISBN pendiente\" por defecto.");
            this.isbn = "ISBN pendiente";
        } else {
            this.isbn = isbn;
        }

        // Validación de copias
        if (copiasDisponibles < 0) {
            System.out.println("Copias inválidas (" + copiasDisponibles
                    + "), se usó 0 por defecto.");
            this.copiasDisponibles = 0;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        // Validación del precio: reutilizamos setPrecioReposicion (una sola regla)
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido, se usó $15000.0 por defecto.");
            this.precioReposicion = 15000.0;
        }
    }

    // ============================================
    // CONSTRUCTOR DE CONVENIENCIA - delega con this(...)
    // No repite validaciones: el canónico las hace.
    // ============================================
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    // ============================================
    // GETTERS - solo lectura del estado
    // ============================================
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    // ============================================
    // SETTER VALIDADO - devuelve true si acepta, false si rechaza
    // ============================================
    public boolean setPrecioReposicion(double precio) {
        if (precio > 0) {
            this.precioReposicion = precio;
            return true;
        }
        return false; // rechaza sin tocar el valor anterior
    }

    // ============================================
    // MÉTODOS DE DOMINIO (en lugar de setCopiasDisponibles)
    // ============================================
    public boolean prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo
                    + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        } else {
            System.out.println("Error: no hay copias disponibles de \""
                    + titulo + "\" para prestar.");
            return false; // no toca el atributo
        }
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo
                + "\". Copias disponibles: " + copiasDisponibles);
    }

    // ============================================
    // FICHA FORMATEADA
    // ============================================
    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("=======================");
    }
}
