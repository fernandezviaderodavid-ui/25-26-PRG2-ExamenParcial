class Mesa {
    private int numero;
    private int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }
}

class Plato {
    private String nombre;
    private String tipo;
    private double precio;

    public Plato(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}

class Reserva {
    private String cliente;
    private Mesa mesa;
    private String fecha;
    private String hora;
    private int personas;

    public Reserva(String cliente, Mesa mesa, String fecha, String hora, int personas) {
        if (personas > mesa.getCapacidad()) {
            System.out.println("Error: demasiadas personas para la mesa");
            return;
        }

        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.personas = personas;
    }

    public double calcularCoste(Plato[] platos) {
        double total = 0;

        for (int i = 0; i < platos.length; i++) {
            total += platos[i].getPrecio();
        }

        return total;
    }

    public void mostrarReserva() {
        System.out.println(cliente + " - Mesa " + mesa.getNumero()
                + " - " + fecha + " " + hora
                + " - " + personas + " personas");
    }
}

public class Restaurante {

    public static void main(String[] args) {

        Mesa mesa = new Mesa(2, 4);

        Plato[] platos = {
                new Plato("Ensalada César", "Entrante", 12),
                new Plato("Filete de ternera", "Principal", 25),
                new Plato("Flan de huevo", "Postre", 6)
        };

        Reserva reserva = new Reserva(
                "Pedro García",
                mesa,
                "01/04/2025",
                "20:00",
                4
        );

        reserva.mostrarReserva();

        double total = reserva.calcularCoste(platos);

        System.out.println("Coste total: " + total + "€");
    }
}
