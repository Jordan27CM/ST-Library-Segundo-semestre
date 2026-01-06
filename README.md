# BibliotecaPrueba2
Contexto 
- Sistema creado para la evaluacion final de la asignatura Programacion Orientada a Objetos cursada en 2 semestre en IP Santo Tomas  

Descripción breve
- Aplicación de gestión de biblioteca escrita en Java (NetBeans) con interfaz gráfica Swing.

Qué hace
- Administra libros, usuarios (empleados/usuarios) y salas: alta, edición, eliminación, consultas, solicitudes, préstamos y devoluciones.
- Interfaz de formularios que permite al personal y usuarios gestionar inventario y reservas de salas.

Cómo funciona 
- La UI (formularios NetBeans) llama a clases DAO para realizar operaciones sobre la base de datos.
- `Conexion.java` gestiona la conexión; los DAOs encapsulan consultas SQL y operaciones CRUD.
- `TMLibros`, `TMSalas` y `TMUsuario` son modelos de tabla usados para mostrar datos en tablas Swing.
