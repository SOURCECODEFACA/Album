package copamerica.modelos;

/**
 * Created by ing daniel on 17/03/2015.
 */
public class Lamina {

    private int id;
    private int ficha;
    private int fondo;
    private String estado;
    private String tipo;
    private String color;
    private int banner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }
}
