package datos;

import dominio.Cliente;
import dominio.Tarea;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Steven Martin
 */
public class TareaDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_tarea, ticket, fecha_inicio_tarea, fecha_fin_tarea, item, id_sede, rda, id_sitio, id_usuario "
            + " FROM TAREAS";
    private static final String SQL_SELECT_BY_ID = "SELECT idcliente, nombre, apellido, email, telefono, saldo "
            + " FROM cliente WHERE idcliente=?";
    private static final String SQL_INSERT = "INSERT INTO TAREAS(ticket, fecha_inicio_tarea, fecha_fin_tarea, item, id_sede, rda, id_sitio, id_usuario)"
            + "VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente "
            + " SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE idcliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idcliente = ?";

    public List<Tarea> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> tareas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTarea = rs.getInt("id_tarea");
                String ticket = rs.getString("ticket");
                String fechaInicioTarea = rs.getString("fecha_inicio_tarea");
                String fechaFinTarea = rs.getString("fecha_fin_tarea");
                int item = rs.getInt("item");
                int idSede = rs.getInt("id_sede");
                String rda = rs.getString("rda");
                int idSitio = rs.getInt("id_sitio");
                int idUsuario = rs.getInt("id_usuario");

                tarea = new Tarea(idTarea, ticket, fechaInicioTarea, fechaFinTarea, item, idSede, rda, idSitio, idUsuario);
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tareas;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//Nos posicionamos en el primer registro
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertar(Tarea tarea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tarea.getTicket());
            stmt.setString(2, tarea.getFechaInicioTarea());
            stmt.setString(3, tarea.getFechaFinTarea());
            stmt.setInt(4, tarea.getItem());
            stmt.setInt(5, tarea.getIdSede());
            stmt.setInt(6, tarea.getItem());
            stmt.setInt(7, tarea.getIdSitio());
            stmt.setInt(8, tarea.getIdUsuario());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
