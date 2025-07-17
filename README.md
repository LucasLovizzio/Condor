# Respuestas bases de datos

A.

Opción correcta: d)

a) Selecciona de las tablas de suppliers y proyectos, pero puede ser que no estén relacionados en SPP. Es decir, el proveedor puede ser de la misma ciudad pero que no este participando de este proyecto.

b) Pasa como en la query a), la única diferencia es que ahora si busca en SPP, pero solamente se asegura de que el proyecto pertenezca a SPP y le falta asegurarse de que el proveedor pertenezca a ese mismo SPP.  Va a devolver cualquier proyecto que este en esa ciudad y pertenezca a SPP, con cualquier proveedor que este en esa ciudad y puede ser que no pertenezca a SPP.

c) Devuelve el nombre de los proyectos donde en esa misma ciudad existan proveedores, ya que los proyectos tienen que estar en las mismas ciudades que los proveedores. Al no relacionar con SPP no te asegura que el proyecto y el proveedor pertenezcan al mismo SPP.

d) Hace las relaciones entre suppliers, proyectos y SPP de manera de que solo devuelva esos P.name que estan en P.City = S.City y pertenezcan al mismo SPP.

B.  

Implementación correcta: A

Normaliza la redundancia de city que hay en Suppliers y Projects utilizando simplemente una tabla aparte. 
  
Ahora Suppliers y Projects tienen una FK que hace referencia a un elemento (ciudad) de la tabla Cities. Incluso facilita a que el día de mañana se agreguen columnas para describir un poco mas a la ciudad sin tener que cambiar la implementación de Projects o Suppliers.

En B y D la City hace referencia a el SPP, por eso esta mal.

En C la relación es como la de B pero al revés. Cities guarda una FK para Projects y otra para Suppliers, no tiene sentido que se haga así. Cities depende ahora de que tenga un Project y un Supplier para poder existir, se convierte en una entidad débil.  

