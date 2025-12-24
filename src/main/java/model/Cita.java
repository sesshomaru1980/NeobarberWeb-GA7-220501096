package co.sena.neobarber.model;

public class Cita {
    private int id;
    private String nombre, correo, telefono, fecha, hora, barbero, servicio, precio;

    public Cita(int id, String nombre, String correo, String telefono, String fecha,
                String hora, String barbero, String servicio, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;
        this.barbero = barbero;
        this.servicio = servicio;
        this.precio = precio;
    }


    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getBarbero() { return barbero; }
    public String getServicio() { return servicio; }
    public String getPrecio() { return precio; }
}
