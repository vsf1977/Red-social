$(document).ready(function()
{
  verificar_sesion()

  var doc = prompt("Please enter some text", 
                "GeeksforGeeks"); 

  $("#ingresar").click(function ()
  {
    var usuario = $("#usuario").val()
    var clave = $("#clave").val()
    $.ajax({
      url:"Ingresar",
      type:'POST',
      data:{'usuario':usuario,'password':clave},
      success: function(result)      
      { 
        if (result == 1)
        {
          window.location.href = "main.html"
        }
        else
        {
          M.toast({html: 'Usuario o contraseña errada'})
        }
      }
    })
  })


  $("#registrar").click(function()
  {
      $(".forma_registro").dialog
      ({
          title : "Registrate en nuestra red social",
          resizable: false,
          height : "auto",
          width : "40%",
          modal : true,
          buttons:
            [
                {
                    text: "Registrarme",
                    click: function()
                    {
                      if (verificar_datos())
                      {
                        var res = verificar_usuario($("#reg_usuario").val().trim())
                        if (res.length > 0)
                        {
                          M.toast({html: 'Este usuario ya existe'})
                        }
                        else
                        {
                          insertar_usuario()
                        }
                      }                      
                    }
                }
            ]
      })
  })


  function verificar_sesion()
  {
    $.ajax({
      url:"VerificarSesion",
      success: function(result)
      {     
        if (result != 0)
        {
          window.location.href = "main.html"
        }
      }
    })
  }


  function verificar_datos()
  {  
    var res = false
    if ($("#reg_usuario").val().trim() == "")
    {
      M.toast({html: 'Debe digitar un nombre de Usuario'})      
    }
    else
      if ($("#reg_clave").val().trim() == "")
      {
        M.toast({html: 'Debe digitar una clave'})        
      }
      else
        if ($("#reg_clave").val().length < 6)
        {
          M.toast({html: 'La clave debe tener minimo 6 caracteres'})
        }
        else
          if ($("#nombre").val().trim() == "")
          {
            M.toast({html: 'Debe digitar su nombre de pila'})
          }
          else
            if ($("#fecha_nac").val() == "")
            {
              M.toast({html: 'Debe digitar su fecha de nacimiento'})
            }
            else
            {              
              res = true
            }
            return res
            

  }


  function verificar_usuario(user)
  {
    var usuario = user
    var res 
    $.ajax({
      url:"VerificarUsuario",
      async:false,
      data:{'usuario':usuario},
      success: function(result)
      {  
        res = result
      }
    })
    return res
  }


  function insertar_usuario()
  {
    var usuario = $("#reg_usuario").val()
    var clave = $("#reg_clave").val()
    var nombre = $("#nombre").val()
    var fecha_nac = $("#fecha_nac").val()
    var ciudad = $("#ciudad").val()
    var telefono = $("#telefono").val()
    $.ajax({
      url:"InsertarUsuario",    
      type:'POST',  
      data:{'usuario':usuario,'clave':clave,'nombre':nombre,'fecha_nac':fecha_nac,'ciudad':ciudad,'telefono':telefono},
      success: function(result)      
      { 
        if (result == 1)
        {
          window.location.href = "main.html"
        }
        else
        {
          M.toast({html: 'Ocurrio un error al momento de guardar el usuario'})
        }
      }
    })
  }

})
