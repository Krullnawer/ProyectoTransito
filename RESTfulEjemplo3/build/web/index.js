function listar() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/',
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            console.log("Success: ", data);
            llenarTabla(data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}

function conteoElementos() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/count',
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            console.log("Success: ", data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}

function guardar() {
    var id = document.getElementById("id").value;
    var summary = document.getElementById("summary").value;
    var description = document.getElementById("description").value;

    json = {id: id, summary: summary, description: description};
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify(json),
        success: function (data) {
            console.log("Success: ", data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}

function modificar() {
    json = {"id": "a4555", "summary": "chevy", "description": "2000"};
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify(json),
        success: function (data) {
            console.log("Success: ", data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}


function eliminar() {
    id = "1225";
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'DELETE',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/' + id,
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            console.log("Success: ", data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}

function actualizar() {
    json = {"id": "a4555", "summary": "chevy", "description": "2000"};
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'PUT',
        url: 'http://localhost:8085/RESTfulEjemplo3/webresources/todos/',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify(json),
        success: function (data) {
            console.log("Success: ", data);
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}


function construirTablaPersonas() {
    $.ajax({
        data: {accion: 'obtenerListaPersonas'},
        type: 'POST',
        url: 'controlador.php',
        success: function (data) {
            console.log("success: ", JSON.parse(data));
            llenarTabla(JSON.parse(data));
        },
        error: function (data) {
            console.log("Error: ", data);
        }
    });
}
;

function llenarTabla(data) {
    document.getElementById('tablatodo').removeChild(document.getElementById('tablatodo').tBodies[0]);
    document.getElementById('tablatodo').appendChild(document.createElement("tbody"));
    for (var i = 0; i < data.length; i++) {
        var botonEliminar = document.createElement("INPUT");
        botonEliminar.setAttribute("type", "button");
        botonEliminar.setAttribute("id", data[i].cedula);
        botonEliminar.setAttribute("value", "eliminar");
        botonEliminar.onclick = function (evt) {
            console.log(evt.target.id);
        };
        crearFila([data[i].id, data[i].summary, data[i].description, botonEliminar]);
    }
}

function crearFila(datos) {
    var tr = document.createElement('tr');
    var len = datos.length;
    for (var i = 0; i < len; i++) {
        var td = document.createElement('td');
        if (datos[i].type === "button") {
            td.appendChild(datos[i]);
        } else {
            td.appendChild(document.createTextNode(datos[i]));
        }
        tr.appendChild(td);
    }
    document.getElementById('tablatodo').tBodies[0].appendChild(tr);
}
;

