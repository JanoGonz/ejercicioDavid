import java.time.LocalDate;

/**
 * Write a description of class SistemaOperativo here.
 *
 * @David Martínez Bardón (your name)
 * @1.0 (a version number or a date)
 */
public class SistemaOperativo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int version;
    private LocalDate parcheDeSeguridad;
    private boolean estable;
    private int numeroIdentificativo;

    /**
     * Constructor for objects of class SistemaOperativo
     */
    public SistemaOperativo(String nombre, int version, int day, int month, int year, boolean estable, int numeroIdentificativo)
    {
        this.nombre = nombre;
        this.version = version;
        this.parcheDeSeguridad = parcheDeSeguridad.of(year, month, day);
        this.estable = estable;
        this.numeroIdentificativo = numeroIdentificativo;
    }

    public String getNombre () {
        return this.nombre;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public LocalDate getFechaParcheDeSeguridad() {
        return this.parcheDeSeguridad;
    }
    
    public boolean getEsEstable() {
        return this.estable;
    }
    
    public int getNumeroIdentificativo() {
        return this.numeroIdentificativo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setFechaDeParcheDeSeguridad(int day, int month, int year) {
        this.parcheDeSeguridad = parcheDeSeguridad.of(year, month, day);
    }
    
    public void setEsEstable(boolean estable) {
        this.estable = estable;
    }
}  