<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="co.sena.neobarber.model.Cita" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NeoBarber - Citas Agendadas</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; padding: 20px; }
        .container { max-width: 1200px; margin: 0 auto; }
        h1 { color: white; text-align: center; margin-bottom: 30px; text-shadow: 0 2px 10px rgba(0,0,0,0.3); }


        .cita-destacada { background: linear-gradient(135deg, #4CAF50, #45a049); color: white; padding: 25px; border-radius: 15px; margin-bottom: 30px; box-shadow: 0 10px 40px rgba(76,175,80,0.4); animation: slideIn 0.5s ease-out; }
        @keyframes slideIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }
        .cita-destacada h2 { margin: 0 0 20px 0; text-align: center; font-size: 24px; }
        .cita-info { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 15px; font-size: 16px; }
        .precio-destacado { color: #FFD700; font-size: 22px; font-weight: bold; }


        .tabla-container { background: white; border-radius: 15px; box-shadow: 0 15px 35px rgba(0,0,0,0.1); overflow: hidden; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 15px 12px; text-align: left; border-bottom: 1px solid #eee; }
        th { background: linear-gradient(135deg, #667eea, #764ba2); color: white; font-weight: 600; }
        tr:hover { background: #f8f9ff; transform: scale(1.01); transition: all 0.2s; }
        .precio { color: #4CAF50; font-weight: bold; font-size: 16px; }


        .btn { background: linear-gradient(135deg, #4CAF50, #45a049); color: white; padding: 12px 25px; border: none; border-radius: 25px; cursor: pointer; text-decoration: none; display: inline-block; font-weight: 600; transition: all 0.3s; }
        .btn:hover { transform: translateY(-2px); box-shadow: 0 8px 25px rgba(76,175,80,0.4); }
        .btn-agendar { display: block; width: 200px; margin: 20px auto; text-align: center; }

        @media (max-width: 768px) { .cita-info { grid-template-columns: 1fr; } th, td { padding: 10px 8px; font-size: 14px; } }
    </style>
</head>
<body>
<div class="container">

    <div style="text-align: center; padding: 15px 0;">
        <img src="neobarber-logo.png" alt="NeoBarber"
             style="width: 140px; height: auto; border-radius: 12px;">
    </div>

    <div class="container">
    <h1>💈 NeoBarber - Citas Agendadas</h1>



    <%
        Cita nuevaCita = (Cita) request.getAttribute("nuevaCita");
        if (nuevaCita != null) {
    %>
    <div style="background: linear-gradient(135deg, #4CAF50, #45a049); color: white; padding: 20px; border-radius: 12px; margin-bottom: 25px; text-align: center; font-size: 24px; font-weight: bold; box-shadow: 0 8px 32px rgba(76,175,80,0.3);">
        ✅ Cita agendada correctamente
    </div>
    <%
        }
    %>



    <div class="tabla-container">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Servicio</th>
                <th>Precio</th>
                <th>Barbero</th>
                <th>Teléfono</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Cita> citas = (List<Cita>) request.getAttribute("citas");
                if (citas != null && !citas.isEmpty()) {
                    for (Cita cita : citas) {
            %>
            <tr>
                <td><%= cita.getId() %></td>
                <td><strong><%= cita.getNombre() %></strong></td>
                <td><%= cita.getFecha() %></td>
                <td><%= cita.getHora() %></td>
                <td><%= cita.getServicio() %></td>
                <td><span class="precio">💰 <%= cita.getPrecio() %></span></td>
                <td><%= cita.getBarbero() %></td>
                <td><%= cita.getTelefono() %></td>
            </tr>
            <%      }
            } else { %>
            <tr>
                <td colspan="8" style="text-align: center; padding: 40px; color: #666;">
                    No hay citas agendadas aún
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

    <a href="agendarCita.html" class="btn btn-agendar">➕ Agendar Nueva Cita</a>
</div>
</body>
</html>
