package datos;

import dominio.Cliente;
import dominio.Sucursal;
import dominio.Tarea;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Steven Martin
 */
public class SucursalDaoJDBC {

    private static final String SQL_SELECT = "SELECT CODIGO_SUCURSAL, DESCRIPCION, RANGO_FACTURACION, DIRECCION, FECHA_ACT, FECHA_ING, USER_ING, USER_ACT, RESTRICTIVA, C_EMPRESA "
            + " FROM SUCURSAL";
    private static final String SQL_SELECT_BY_ID = "SELECT CODIGO_SUCURSAL, DESCRIPCION, RANGO_FACTURACION, DIRECCION, FECHA_ACT, FECHA_ING, USER_ING, USER_ACT, RESTRICTIVA, C_EMPRESA "
            + " FROM SUCURSAL WHERE CODIGO_SUCURSAL=?";
    private static final String SQL_INSERT = "INSERT INTO SUCURSAL(CODIGO_SUCURSAL, DESCRIPCION, RANGO_FACTURACION, DIRECCION, FECHA_ACT, FECHA_ING, USER_ING, USER_ACT, RESTRICTIVA, C_EMPRESA)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE SUCURSAL "
            + " SET DESCRIPCION=?, RANGO_FACTURACION=?, DIRECCION=?, FECHA_ACT=?, FECHA_ING=?, USER_ING=?, USER_ACT=?, RESTRICTIVA=?, C_EMPRESA=? WHERE CODIGO_SUCURSAL=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idcliente = ?";

    public List<Sucursal> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sucursal sucursal = null;
        List<Sucursal> sucursales = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoSucursal = rs.getInt("CODIGO_SUCURSAL");
                String descripcion = rs.getString("DESCRIPCION");
                String rangoFacturacion = rs.getString("RANGO_FACTURACION");
                String direccion = rs.getString("DIRECCION");
                String fechaAct = rs.getString("FECHA_ACT");
                String fechaIng = rs.getString("FECHA_ING");
                String userIng = rs.getString("USER_ING");
                String userAct = rs.getString("USER_ACT");
                String restrictiva = rs.getString("RESTRICTIVA");
                int cEmpresa = rs.getInt("C_EMPRESA");

                sucursal = new Sucursal(codigoSucursal, descripcion, rangoFacturacion, direccion, fechaAct, fechaIng, userIng, userAct, restrictiva, cEmpresa);
                sucursales.add(sucursal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sucursales;
    }

    public Sucursal encontrar(Sucursal sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, sucursal.getCodigoSucursal());
            rs = stmt.executeQuery();
            rs.absolute(1);//Nos posicionamos en el primer registro
            String descripcion = rs.getString("DESCRIPCION");
            String rangoFacturacion = rs.getString("RANGO_FACTURACION");
            String direccion = rs.getString("DIRECCION");

            sucursal.setDescripcion(descripcion);
            sucursal.setRangoFacturacion(rangoFacturacion);
            sucursal.setDireccion(direccion);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sucursal;
    }

    public int insertar(Sucursal sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, sucursal.getCodigoSucursal());
            stmt.setString(2, sucursal.getDescripcion());
            stmt.setString(3, sucursal.getRangoFacturacion());
            stmt.setString(4, sucursal.getDireccion());
            stmt.setString(5, sucursal.getFechaActualizacion());
            stmt.setString(6, sucursal.getFechaIngreso());
            stmt.setString(7, sucursal.getUserIngreso());
            stmt.setString(8, sucursal.getUserActualizacion());
            stmt.setString(9, sucursal.getRestrictiva());
            stmt.setInt(10, sucursal.getcEmpresa());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Sucursal sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, sucursal.getCodigoSucursal());
            stmt.setString(2, sucursal.getDescripcion());
            stmt.setString(3, sucursal.getRangoFacturacion());
            stmt.setString(4, sucursal.getDireccion());
            stmt.setString(5, sucursal.getFechaActualizacion());
            stmt.setString(6, sucursal.getFechaIngreso());
            stmt.setString(7, sucursal.getUserIngreso());
            stmt.setString(8, sucursal.getUserActualizacion());
            stmt.setString(9, sucursal.getRestrictiva());
            stmt.setInt(10, sucursal.getcEmpresa());
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
