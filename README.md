dengue-maps-server
==================

Este trabajo se llevó a cabo en la Materia **Electiva 6 Datos Abiertos** de la Carrera Ingeniería en Informática de la Facultad Politécnica de la Universidad Nacional de Asunción, cátedra del Dr. Prof. Juan Pane y ayudante de cátedra Ing. Rodrigo Parra. El Ministerio de Salud Pública y Bienestar Social publica semanalmente a través de su Portal Web los mapas de riesgo correspondientes a la enfermedad epidemiológica **Dengue**. El objetivo del trabajo fue realizar un aporte a la sociedad, proveyendo la misma información en mapas interactivos que permitan realizar las consultas y visualizar la información de una manera más dinámica y comprensible para el usuario final.

Este proyecto contiene los servicios rest que sirven al cliente **dengue-maps**. Los servicios retornan datos en formato json, los mismos pueden ser utilizados para diferentes aplicaciones además de los mapas de riesgos.

Autores
-------
* Natalia Valdez Turcott
* Verena Ojeda Azocar

Instalación
------------
1. Para poder realizar la instalación de este proyecto es necesario tener previamente instalado un servidor de aplicaciones JBoss AS7, un servidor web Apache y una base de datos PostgreSQL.
    
2. Crear la base de datos con el nombre **denguemaps**, propietario **postgres**.

3. Agregar el contenido del archivo datasource.txt en el standalone.xml del servidor JBoss.
    
4. Clonar este repositorio:

 `$ git clone https://github.com/verena91/dengue-maps-server.git`
    
5. Realizar un restore de la base de datos con el archivo RESTORE-DB.sql.

6. Deployar el proyecto en el servidor JBoss.

7. Crear un proxy pass en el servidor web Apache a la ruta donde se despliega la aplicación en el JBoss.

8. Acceder desde el navegador, en la dirección donde se despliega el Apache seguido del nombre del proyecto.

    **Ejemplo**

    https://localhost/dengue-maps-server

**Para los detalles de instalación y configuración del cliente ir a:**

[dengue-maps!](https://github.com/verena91/dengue-maps)

Licencias
---------
* LGPL Lesser General Public Licence
* CC BY-SA Creative Commons Attribution Share Alike
