<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Nueva Sucursal</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div> 
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required></input>
                    </div>
                    <div class="form-group">
                        <label for="rangoFacturacion">Rango Facturacion</label>
                        <input type="text" class="form-control" name="rangoFacturacion" required></input>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" class="form-control" name="direccion" required></input>
                    </div>
                    <!--
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="email" class="form-control" name="email" required></input>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required></input>
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required step="any"></input>
                    </div> -->
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>