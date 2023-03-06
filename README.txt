La aplicación puede desplegarse desde un IDE teniendo como "goal" spring-boot:run. Se establecerá como DataSource una BD MySQL 
y la api REST se despliega sobre un servidor Apache Tomcat. Se ha utilizado el framework Spring para facilitar el mapeado y acceso a datos 
y la configuración general del proyecto, así como Maven para la gestión de dependencias.

El código se estructura en 4 paquetes: entities, dtos, daos y controllers. En el paquete entities se encuentran las entidades que se
corresponden a tablas de la BD, en el paquete dtos se encuentran los objetos de transferencia de datos para poder realizar la consulta 
compleja de la tarea 2, en el paquete daos tenemos los objetos de acceso a datos, de tipo CrudRepository, y por último en el paquete controllers
están los controladores REST necesarios para establecer las operaciones HTTP sobre los recursos.