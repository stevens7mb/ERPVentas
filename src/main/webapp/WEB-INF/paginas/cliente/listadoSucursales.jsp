<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_GT"></fmt:setLocale>

    <section id="clientes">
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <div class="card">
                        <div class="card-header">
                            <h4>Sucursales</h4>
                        </div>
                        <table class="table table-responsive-xl table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Código Sucursal</th>
                                    <th>Descripción</th>
                                    <th>Rango Facturación</th>
                                    <th>Fecha Ingreso</th>
                                    <th>Código de Empresa</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Iteramos cada elemento de la lista de clientes-->
                            <c:forEach var="sucursal" items="${sucursales}" varStatus="status">
                                <tr>
                                    <td>${sucursal.codigoSucursal}</td>
                                    <td>${sucursal.descripcion} </td>
                                    <td>${sucursal.rangoFacturacion} </td>
                                    <td>${sucursal.fechaIngreso} </td>
                                    <td>${sucursal.cEmpresa} </td>
                                   <!-- <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/> </td>    -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&codigoSucursal=${sucursal.codigoSucursal}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Tarjetas para los totales -->
            <div class="col-md-3">
                <!--
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div> -->
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Sucursales</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalSucursales}
                        </h4>
                    </div>
                </div>
            </div>
            <!-- Fin Tarjetas para los totales -->
        </div>
    </div>
</section>
<!-- Agregar cliente Modal-->
<jsp:include page="/WEB-INF/paginas/cliente/agregarSucursal.jsp"/>
