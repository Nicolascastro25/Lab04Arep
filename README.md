# Lab 04 Arep
## Definición problema:
Para la tarea usted debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS usando EC2 y Docker.

![image](https://user-images.githubusercontent.com/25957863/197447879-8a3e1260-ff10-4b0b-81d6-02b1d171852b.png)

1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

## Desarrollo: 

Creamos un archivo denominado Dockerfile con el siguiente contenido:

![image](https://user-images.githubusercontent.com/25957863/197449903-fe59c7b3-7749-4e7e-8a8c-2c4aca877754.png)

Usando la herramienta de línea de comandos de Docker construya la imagen:

`docker build --tag dockersparkprimer .`

Creamos en la raíz del directorio el archivo docker-compose.yml con le siguiente contenido:

![image](https://user-images.githubusercontent.com/25957863/197450094-690c4ef5-a308-45a6-9099-0cf0e9d250b8.png)

Subiendo las imagenes a DockerHub:

Accedemos al menu de repositorios y cree un repositorio:

![image](https://user-images.githubusercontent.com/25957863/197450506-94b2dfa5-0bda-41b5-9486-fd0d0426cdb8.png)

### Montaje en AWS:

![image](https://user-images.githubusercontent.com/25957863/197451308-f0be547e-7837-42e9-927c-5289004ab2fb.png)

![image](https://user-images.githubusercontent.com/25957863/197451371-74c5438e-9cf0-4e2e-92ed-e1a608f3df3a.png)
