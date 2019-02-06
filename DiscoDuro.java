import java.util.ArrayList;

/**
 * Write a description of class DiscoDuro here.
 *
 * @David Martínez Bardón (your name)
 * @1.0 (a version number or a date)
 */
public class DiscoDuro
{
    private ArrayList<SistemaOperativo> sistemas;
    private int numeroIdentificativo = 1;

    /**
     * Constructor for objects of class DiscoDuro
     */
    public DiscoDuro()
    {
        sistemas = new ArrayList<SistemaOperativo>();
    }
    
    public void agregarSistema(String nombre, double version, int day, int month, int year, boolean estable) {
        SistemaOperativo sistemaActual = new SistemaOperativo(nombre, version, day, month, year, estable, numeroIdentificativo);
        sistemas.add(sistemaActual);
        numeroIdentificativo++;
    }
}
