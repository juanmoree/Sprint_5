# Sprint_5

Se utiliza el patrón de diseño MVC (Modelo-Vista-Controlador)

Sucursal: Es la entidad o modelo que se utiliza para interactuar con la base de datos. Esta clase se utiliza en el repositorio, que es la capa que se encarga de las operaciones de la base de datos. 

SucursalDTO: DTO significa Objeto de Transferencia de Datos. Es una clase simple que se utiliza para transferir datos entre la capa de la aplicación y la capa de presentación (la vista). Esta clase no tiene ninguna lógica de negocio y solo contiene campos y sus respectivos métodos getter y setter.  

SucursalService: Esta es la capa de servicios, que se encarga de la lógica de negocio y de la transformación entre la entidad Sucursal y el DTO SucursalDTO. En este caso, se encarga de convertir una entidad Sucursal a un SucursalDTO antes de enviar los datos a la vista, y de convertir un SucursalDTO a una entidad Sucursal cuando los datos vienen de la vista y necesitan ser almacenados en la base de datos.  

SucursalController: Esta es la capa de controlador, que maneja las solicitudes HTTP, utiliza los servicios para obtener o manipular los datos y luego envía los datos (generalmente como SucursalDTO) a la vista.  

En resumen, los datos fluyen desde la base de datos como entidad Sucursal, se convierten a SucursalDTO en la capa de servicios, y luego se envían a la vista desde el controlador. Cuando los datos vienen de la vista, el proceso es al revés: los datos vienen como SucursalDTO, se convierten a la entidad Sucursal en la capa de servicios, y luego se almacenan en la base de datos a través del repositorio.