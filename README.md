# test2Sanitas
1) - Una vez importado el proyecto a eclipse, cambiado build path para que apunte a jdk 1.8.
   - Añadido sportalclientesweb-1.19.0.jar en src/main/resources y añadido al pom.xml como dependencia local interna.
   - Ejecutado commando "mvn clean install" para actualizar dependencias maven. Con esto se resuelven
     los conflictos del proyecto.
     
2) - Incluidos dependecias spring boot al pom.xml.
   - Reestructurado proyecto en servicios, controladores y modelos (estrucutra SpringBoot).
   - Creado clase ZendeskApplication para iniciar api y ZendeskController para crear las peticiones 	 	 REST en el navegador.
   
3) -Añadidos algunos servicios REST asociados a MailService y ZendeskService:
		* http://localhost:8080/   			    -> muestra que la aplicación esta corriendo
		* http://localhost:8080/enviarCorreo    -> avisa al usuario que el correo se envío con éxito
	    * http://localhost:8080/enviarCorreoErr -> avisa al usuario que el correo NO se envío con éxito
	    * http://localhost:8080/alta/*nombre* -> avisa al agente *nombre* no pudo dar de alta a un usaurio
	    
   - No se ha podido testar de forma correcta ZendeskService.altaUsuario() por tiempo
	    
