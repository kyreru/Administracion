
function loadData(){
    let request = sendRequest('paciente/list','GET','')
    let table = document.getElementById('pacientes-tabla')
    table.innerHTML="";

    request.onload = function(){
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
            <tr>
                <th>${element.id_Paciente}</th>
                <th>${element.tipo_Identificacion}</th>
                <th>${element.nombre}</th>
                <th>${element.apellidos}</th>
                <th>${element.telefono}</th>
                <th>${element.eapb}</th>
                <th>${element.email}</th>
                <td>
                <button type="button" class="btn btn-primary" onclink='window.location="/form-paciente.html?id=${element.id_Paciente}"'>Editar</button>
                <button type="button" class="btn btn-danger" onclink='deletePaciente(${element.id_Paciente})'>Eliminar</button>
                </td>
            </tr>
            `
        });
    }

    request.onerror = function(){
        table.innerHTML = 
            <tr>
             <td colspan="6">Error al Recuperar los Datos</td>
            </tr>
            
            ;
    }
}

function loadPaciente(id_Paciente){
    let request = sendRequest('paciente/list'+id_Paciente,'GET','')
    let identificacion = document.getElementById('tipo-ident')
    let tipoN= document.getElementById('tipo-nombre')
    let tipoA = document.getElementById('tipo_apellido')
    let tipoT = document.getElementById('tipo-telefono')
    let tipoeapb = document.getElementById('tipo-eapb')
    let tipoemail = document.getElementById('tipo_email')
    let id = document.getElementById('paciente-id')

    request.onload = function(){
        let data= request.response
        id.value = data.id_Paciente
        identificacion.value = data.tipo_Identificacion
        tipoN.value = data.nombre
        tipoA.value = data.apellidos
        tipoT.value = data.telefono
        tipoeapb.value = data.eapb
        tipoemail.value = data.email
        
    }
    request.onerror = function(){
        alert("error al recuperar datos.")
    }

}

function deletePaciente(id_Paciente){
    let request= sendRequest('paciente/'+id_Paciente, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}

function savePaciente(){
    let identificacion = document.getElementById('tipo-ident').value
    let  tipoN  = document.getElementById('tipo-nombre').value
    let  tipoA  = document.getElementById('tipo_apellido').value
    let  tipoT   = document.getElementById('tipo-telefono').value
    let  tipoeapb = document.getElementById('tipo-eapb').value
    let  tipoemail = document.getElementById('tipo-email').value
    let  id    = document.getElementById('paciente-id').value

    let data = { 'id_paciente': id, 'tipo_id':identificacion,'nombre':tipoN,
    'apellido':tipoA, 'telefono': tipoT, 'eapb': tipoeapb, 'email':tipoemail }
    
    let request = sendRequest('paciente/', id ? 'POST' :  'PUT' , data)
    request.onload = function(){
        window.location = 'paciente.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}

function editarPaciente(){
    let identificacion = document.getElementById('tipo-ident').value
    let  tipoN  = document.getElementById('tipo-nombre').value
    let  tipoA  = document.getElementById('tipo_apellido').value
    let  tipoT   = document.getElementById('tipo-telefono').value
    let  tipoeapb = document.getElementById('tipo-eapb').value
    let  tipoemail = document.getElementById('tipo-email').value
    let  id    = document.getElementById('paciente-id').value

    let data = { 'id_paciente': id, 'tipo_id':identificacion,'nombre':tipoN,
    'apellido':tipoA, 'telefono': tipoT, 'eapb': tipoeapb, 'email':tipoemail }
    
    let request = sendRequest('paciente/', id ? 'PUT' :  'POST' , data)
    request.onload = function(){
        window.location = 'paciente.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }


}