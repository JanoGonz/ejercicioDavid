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

    public String mostrarSistemas() {
        int contador = 0;
        String sistemasAMostrar = "";
        while (contador != sistemas.size()) {
            sistemasAMostrar += sistemas.get(contador).todasLasCaracteristicas();
            contador++;
        }
        return sistemasAMostrar;
    }

    /** El usuario introduce el nombre de los sistemas a clasificar (Windows, Ubuntu, Mac...)
     */
    public String clasificacionPorVersion(String sistema) {
        String sistemasAMostrar = "";
        ArrayList<SistemaOperativo> sistemasBackup = new ArrayList<SistemaOperativo>();
        int contador = 0;
        for (SistemaOperativo sistemaActual : sistemas) {
            if (sistemaActual.getNombre().equals(sistema)) {
                sistemasBackup.add(sistemaActual);
            }
        }
        while (contador < sistemasBackup.size()) {
            int contador2 = contador + 1;
            while (contador2 < sistemasBackup.size()) {
                if (sistemasBackup.get(contador).getVersion() > sistemasBackup.get(contador2).getVersion()) {
                    SistemaOperativo sistemaBackupTemp = null;
                    sistemaBackupTemp = sistemasBackup.get(contador);
                    sistemasBackup.set(contador, sistemasBackup.get(contador2));
                    sistemasBackup.set(contador2, sistemaBackupTemp);
                }
                contador2++;
            }
            contador++;
        }
        for (SistemaOperativo sistemaActual : sistemasBackup) {
            sistemasAMostrar += sistemaActual.getNombre() + sistemaActual.getVersion();
        }
        return sistemasAMostrar;
    }
}