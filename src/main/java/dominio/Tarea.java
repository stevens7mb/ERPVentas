package dominio;

/**
 *
 * @author steven
 */
public class Tarea {

    private int idTarea;
    private String ticket;
    private String fechaInicioTarea;
    private String fechaFinTarea;
    private int item;
    private int idSede;
    private String rda;
    private int idSitio;
    private int idUsuario;

    public Tarea() {
    }

    public Tarea(int idCliente) {
        this.idTarea = idTarea;
    }

    public Tarea(String ticket, String fechaInicioTarea, String fechaFinTarea, Integer item, Integer idSede, String rda, Integer idSitio, Integer idUsuario) {
        this.ticket = ticket;
        this.fechaInicioTarea = fechaInicioTarea;
        this.fechaFinTarea = fechaFinTarea;
        this.item = item;
        this.idSede = idSede;
        this.rda = rda;
        this.idSitio = idSitio;
        this.idUsuario = idUsuario;
    }

    public Tarea(int idTarea, String ticket, String fechaInicioTarea, String fechaFinTarea, Integer item, Integer idSede, String rda, Integer idSitio, Integer idUsuario) {
        this.idTarea = idTarea;
        this.ticket = ticket;
        this.fechaInicioTarea = fechaInicioTarea;
        this.fechaFinTarea = fechaFinTarea;
        this.item = item;
        this.idSede = idSede;
        this.rda = rda;
        this.idSitio = idSitio;
        this.idUsuario = idUsuario;
    }



    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getFechaInicioTarea() {
        return fechaInicioTarea;
    }

    public void setFechaInicioTarea(String fechaInicioTarea) {
        this.fechaInicioTarea = fechaInicioTarea;
    }

    public String getFechaFinTarea() {
        return fechaFinTarea;
    }

    public void setFechaFinTarea(String fechaFinTarea) {
        this.fechaFinTarea = fechaFinTarea;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getRda() {
        return rda;
    }

    public void setRda(String rda) {
        this.rda = rda;
    }

    public int getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(int idSitio) {
        this.idSitio = idSitio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", ticket=" + ticket + ", fechaInicioTarea=" + fechaInicioTarea + ", fechaFinTarea=" + fechaFinTarea + ", item=" + item + ", idSede=" + idSede + ", rda=" + rda + ", idSitio=" + idSitio + ", idUsuario=" + idUsuario + '}';
    }

}
