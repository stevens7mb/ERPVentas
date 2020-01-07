<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Nueva Tarea</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div> 
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="ticket">Ticket</label>
                        <input type="text" class="form-control" name="ticket" required></input>
                    </div>
                    <div class="form-group">
                        <label for="fechaInicioTarea">Fecha Inicio de Tarea</label>
                        <input type="text" class="form-control" name="fechaInicioTarea" required></input>
                    </div>
                    <div class="form-group">
                        <label for="fechaFinTarea">Fecha Fin Tarea</label>
                        <input type="text" class="form-control" name="fechaFinTarea" required></input>
                    </div>
                    <div class="form-group">
                        <label for="item">Item</label>
                        <input type="text" class="form-control" name="item" required></input>
                    </div>
                    <div class="form-group">
                        <label for="idSede">ID de la Sede</label>
                        <input type="text" class="form-control" name="idSede" required></input>
                    </div>
                    <div class="form-group">
                        <label for="rda">RDA</label>
                        <input type="text" class="form-control" name="rda" required></input>
                    </div>
                     <div class="form-group">
                        <label for="idSitio">ID del Sitio</label>
                        <input type="text" class="form-control" name="idSitio" required></input>
                    </div>
                    <div class="form-group">
                        <label for="idUsuario">ID del Usuario</label>
                        <input type="text" class="form-control" name="idUsuario" required></input>
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