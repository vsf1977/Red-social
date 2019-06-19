$(document).ready(function()
{
  var mes = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
    
  cargar_usuario()

  $(".dropdown-trigger").dropdown(
    {
      inDuration: 300,
      outDuration: 225,
      hover: true,
      coverTrigger: false
  })

  function cargar_usuario()
  {
    $.ajax({
      url:"InfoUsuario",
      success: function(result)
      {  
        var fecha = new Date(result.fecha_nac)
        var primer_nombre = result.nombre.substr(0,result.nombre.indexOf(' '))
        $("#nombre").text(result.nombre)
        $("#ciudad").text(result.ciudad)
        $(".usuario_opciones").text(primer_nombre)
        $(".nombre-user").text(primer_nombre)
        $("#cumpleaños").text(fecha.getDate() + " de " + mes[fecha.getMonth()])
      }
    })
  }

  function cerrar_sesion()
  {
    $.ajax({
      url:"CerrarSesion",
      success: function(result)
      {  
        window.location.href = "index.html"
      }
    })
  }

  function cerrar_cuenta()
  {
    $.ajax({
      url:"BorrarUsuario",
      success: function(result)
      {  
        if (result != 0)
        {
          M.toast({html: 'Cuenta eliminada'})
          window.location.href = "index.html"
        }
        else
        {
          M.toast({html: 'Ocurrio un error al momento de borrar el usuario'})
        }
      }
    })
  }


  $("#Cerrar_sesion").click(function()
  {
    cerrar_sesion()
  })

  
  $("#Cerrar_cuenta").click(function()
  {    
    if (confirm('Desea borrar la cuenta?')) 
    {
      cerrar_cuenta()
    }
  })

})
