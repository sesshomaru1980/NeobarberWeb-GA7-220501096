package co.sena.neobarber.servlet;

import co.sena.neobarber.model.Cita;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/citas")
public class CitaServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/neobarber?useSSL=false&serverTimezone=America/Bogota&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "6162912";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Cita> citas = obtenerTodasCitas();
        req.setAttribute("citas", citas);
        req.getRequestDispatcher("/citas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cita nuevaCita = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ MySQL CONECTADO");


            String nombre = req.getParameter("nombre");
            String correo = req.getParameter("correo");
            String telefono = req.getParameter("telefono");
            String fecha = req.getParameter("fecha");
            String hora = req.getParameter("hora");
            String barbero = req.getParameter("barbero");
            int servicioId = Integer.parseInt(req.getParameter("servicio"));


            String sqlServ = "SELECT nombre, precio FROM servicios WHERE id = ?";
            PreparedStatement stmtServ = conn.prepareStatement(sqlServ);
            stmtServ.setInt(1, servicioId);
            ResultSet rs = stmtServ.executeQuery();

            String servicio = "Desconocido", precio = "0";
            if (rs.next()) {
                servicio = rs.getString("nombre");
                precio = rs.getString("precio");
            }

            // INSERTAR CITA
            String sql = "INSERT INTO citas (nombre, correo, telefono, fecha, hora, barbero, servicio, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, telefono);
            stmt.setString(4, fecha);
            stmt.setString(5, hora);
            stmt.setString(6, barbero);
            stmt.setString(7, servicio);
            stmt.setString(8, precio);
            stmt.executeUpdate();


            nuevaCita = new Cita(0, nombre, correo, telefono, fecha, hora, barbero, servicio, precio);
            System.out.println("✅ CITA GUARDADA: " + nombre);

        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }


        List<Cita> todasCitas = obtenerTodasCitas();
        req.setAttribute("citas", todasCitas);
        req.setAttribute("nuevaCita", nuevaCita);
        req.getRequestDispatcher("/citas.jsp").forward(req, resp);
    }

    private List<Cita> obtenerTodasCitas() {
        List<Cita> citas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM citas ORDER BY id DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                citas.add(new Cita(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("barbero"),
                        rs.getString("servicio"),
                        rs.getString("precio")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ ERROR OBTENER CITAS: " + e.getMessage());
        }
        return citas;
    }
}
