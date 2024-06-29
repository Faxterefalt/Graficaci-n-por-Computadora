import java.util.ArrayList;
import componentes.objetos3D.Objeto3D;
public class Escena {
    private ArrayList<Objeto3D> objetos;

    public Escena() {
        objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto3D objeto) {
        objetos.add(objeto);
    }

    public ArrayList<Objeto3D> getObjetos() {
        return objetos;
    }
}
