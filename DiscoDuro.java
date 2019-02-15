import java.util.ArrayList;
import java.util.Iterator;

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

    /**
     * Este método permite agregar nuevos sistemas; en el que es necesario
     * introducir los datos que se soliciten.
     */
    public void agregarSistema(String nombre, double version, int day, int month, int year, boolean estable) {
        SistemaOperativo sistemaActual = new SistemaOperativo(nombre, version, day, month, year, estable, numeroIdentificativo);
        sistemas.add(sistemaActual);
        numeroIdentificativo++;
    }

    /**
     * Este método muestra los sistemas con toda la información.
     */
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
        for (SistemaOperativo sistemaActual : sistemas) {
            if (sistemaActual.getNombre().equals(sistema)) {
                sistemasBackup.add(sistemaActual);
            }
        }
        int i=0;
        while(i<sistemasBackup.size()) {
            int posicionAMirar = i;
            SistemaOperativo aux = sistemasBackup.get(posicionAMirar);
            while ((posicionAMirar > 0) && (sistemasBackup.get(posicionAMirar-1).getVersion()> aux.getVersion())){
                sistemasBackup.remove(posicionAMirar);
                sistemasBackup.add(posicionAMirar-1,aux);
                posicionAMirar--;
            }
            i++;
        }
        for (SistemaOperativo sistemaActual : sistemasBackup) {
            sistemasAMostrar += sistemaActual.getNombre() + sistemaActual.getVersion() + "\n";
        }
        return sistemasAMostrar;
    }

    /** El método clasifica aquellos sistemas en función de su parche de seguridad 
     * mas reciente y si son estables.
     */
    public String clasificacionParcheDeSeguridadYEstables() {
        String sistemasAMostrar = "";
        ArrayList<SistemaOperativo> sistemasBackup = new ArrayList<SistemaOperativo>();
        int contador = 0;
        for (SistemaOperativo sistemaActual : sistemas) {
            if (sistemaActual.getEsEstable()) {
                sistemasBackup.add(sistemaActual);
            }
        }
        while (contador < sistemasBackup.size()) {
            int contador2 = contador + 1;
            while (contador2 < sistemasBackup.size()) {
                if (sistemasBackup.get(contador).getFechaParcheDeSeguridad().isAfter(sistemasBackup.get(contador2).getFechaParcheDeSeguridad())) {
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
            sistemasAMostrar += sistemaActual.getNombre() + " " + sistemaActual.getVersion() + " " + sistemaActual.getFechaParcheDeSeguridad() + "\n";
        }
        return sistemasAMostrar;
    }

    /**NECESITA UNA VERSIÓN MEJOR
     * Este método permite cambiar la estabilidad de cualquier sistema ya sea
     * de false a true y a la inversa. El valor que introduce el usuario es 
     * el numero identificativo
     */
    public void cambiarEstabilidad(int numeroIdentificativo, boolean estabilidad) {
        int contador = 0;
        boolean buscando = true;
        while (contador < sistemas.size() && buscando) {
            if (sistemas.get(contador).getId() == numeroIdentificativo) {
                sistemas.get(contador).setEsEstable(estabilidad);
                buscando = false;
            }
            contador++;
        }
    }

    /**
     * Este método no retorna nada, simplemente elimina aquellos sistemas
     * cuyo atributo estable sea false.
     */
    public void borrarLosNoEstables() {
        Iterator<SistemaOperativo> it = sistemas.iterator();
        while (it.hasNext()) {
            SistemaOperativo sistemaActual = null;
            sistemaActual = it.next();
            if (!sistemaActual.getEsEstable()) {
                it.remove();
            }
        }
    }

    /**
     * Es necesario que el usuario introduzca el nombre de los sistemas a 
     * clasificar (Windows, Ubuntu, Mac...).
     */
    public String ordenarPorVersionYParcheDeSeguridadSiHayEmpate(String sistema) {
        String sistemasAMostrar= "";
        ArrayList<SistemaOperativo> sistemasBackup = new ArrayList();
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
                else if (sistemasBackup.get(contador).getVersion() == sistemasBackup.get(contador2).getVersion() && sistemasBackup.get(contador).getFechaParcheDeSeguridad().isAfter(sistemasBackup.get(contador2).getFechaParcheDeSeguridad())){
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
            sistemasAMostrar += sistemaActual.getNombre() + " " + sistemaActual.getVersion() + " " + sistemaActual.getFechaParcheDeSeguridad() + "\n";
        }
        return sistemasAMostrar;
    }

}