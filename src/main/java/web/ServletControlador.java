package web;

import datos.SucursalDaoJDBC;
import datos.TareaDaoJDBC;
import dominio.Cliente;
import dominio.Sucursal;
import dominio.Tarea;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author steven
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sucursal> sucursales = new SucursalDaoJDBC().listar();
        System.out.println("sucursales =" + sucursales);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("sucursales", sucursales);
        //sesion.setAttribute("totalClientes", clientes.size());
        //sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("sucursales.jsp").forward(request, response);
        response.sendRedirect("sucursales.jsp");
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos los valores del formulario agregarSucursal
        String descripcion = request.getParameter("descripcion");
        String rangoFacturacion = request.getParameter("rangoFacturacion");
        String direccion = request.getParameter("direccion");
        String fechaActualizacion = "2019-12-31";
        String fechaIngreso = "2019-12-31";
        String userIngreso = "Steven";
        String userActualizacion = "Steven";
        String restrictiva = "A";

        Integer cEmpresa = 0;
        String cEmpresaString = "2";
        if (cEmpresaString != null && !"".equals(cEmpresaString)) {
            cEmpresa = Integer.parseInt(cEmpresaString);
        }


        /*
        Integer item = 0;
        String itemString = request.getParameter("item");
        if (itemString != null && !"".equals(itemString)) {
            item = Integer.parseInt(itemString);
        }

        Integer idSede = 0;
        String idSedeString = request.getParameter("idSede");
        if (idSedeString != null && !"".equals(idSedeString)) {
            item = Integer.parseInt(idSedeString);
        }

        String rda = request.getParameter("rda");

        Integer idSitio = 0;
        String idSitioString = request.getParameter("idSitio");
        if (idSitioString != null && !"".equals(idSitioString)) {
            item = Integer.parseInt(idSedeString);
        }

        Integer idUsuario = 0;
        String idUsuarioString = request.getParameter("idUsuario");
        if (idUsuarioString != null && !"".equals(idUsuarioString)) {
            item = Integer.parseInt(idUsuarioString);
        }*/
        //Creamos el objeto de sucursal(modelo)
        //Sucursal sucursal = new Sucursal(descripcion, rangoFacturacion, direccion, fechaActualizacion, fechaIngreso, userIngreso, userActualizacion, restrictiva, cEmpresa);
        Sucursal sucursal = new Sucursal(descripcion, rangoFacturacion, direccion, fechaActualizacion, fechaIngreso, userIngreso, userActualizacion, restrictiva, cEmpresa);
        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new SucursalDaoJDBC().insertar(sucursal);
        System.out.println("registrosModificados = " + registrosModificados);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos los valores del formulario agregarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto de cliente(modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        //Moodificamos el objeto en la base de datos
        int registrosModificados = new TareaDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos los valores del formulario agregarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //Creamos el objeto de cliente(modelo)
        Cliente cliente = new Cliente(idCliente);
        //Eliminamos el objeto en la base de datos
        int registrosModificados = new TareaDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new TareaDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
}
