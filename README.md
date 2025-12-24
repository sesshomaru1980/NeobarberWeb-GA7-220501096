NeoBarber
NeoBarber es una aplicación web full-stack desarrollada en Java para la gestión de citas en una barbería. Permite a los clientes reservar servicios como cortes de cabello, manicura y tratamientos faciales, mientras los administradores manejan el inventario y las agendas.
​

Tecnologías
El proyecto utiliza un stack moderno y probado para desarrollo web:

Backend: Java Servlets y JSP

Base de datos: MySQL

Servidor: Apache Tomcat 9.0.113

Build: Maven

IDE: IntelliJ IDEA 

Frontend: HTML5, CSS3, js y JSP dinámico
​

Estructura del Proyecto


<img width="660" height="290" alt="image" src="https://github.com/user-attachments/assets/daba18f0-81f5-4f9c-97a6-d34001c90b38" />

Instalación
Clona el repositorio: git clone <url>

Importa en IntelliJ/NetBeans como proyecto Maven.

Configura MySQL: ejecuta schema.sql y data.sql en MySQL Workbench.

Actualiza context.xml o propiedades JDBC con tus credenciales de BD.

Despliega en Tomcat: mvn clean package y copia WAR a webapps.

Asegúrate de tener Tomcat corriendo en puerto 8080.

Cliente: Regístrate, selecciona servicio (corte clásico, depilación, etc.) y reserva hora.

Admin: Login con credenciales default (admin/admin), gestiona citas y usuarios.

Funcionalidades
Registro y login de usuarios

Gestión de citas (crear, editar, cancelar)

Catálogo de servicios con precios

Panel administrativo para barberos

Integración con base de datos MySQL para persistencia
Contribuir
Fork el repositorio

Crea branch: git checkout -b feature/nueva-funcion

Commit cambios: git commit -m 'Agrega X'

Push: git push origin feature/nueva-funcion

Abre Pull Request

Sigue las convenciones de código Java y reporta issues

​
