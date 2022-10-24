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

Lanzamos y descargamos la instacia creada para el montaje del contenedor:

![image](https://user-images.githubusercontent.com/25957863/197451638-d3929082-dd85-45b9-9f89-36c7aa19e03c.png)

Una vez montado el contenedor el contenedor nos dirigimos a la siguiente direccion:

![image](https://user-images.githubusercontent.com/25957863/197451720-95075509-c68b-4363-a193-d60cf64646e4.png)

Y vemos nuestro servicio SparkWeb montado con acceso a la base Mongo:

![image](https://user-images.githubusercontent.com/25957863/197451518-a9bd6a04-f25d-40cb-8f8b-32d80f12055d.png)

![image](https://user-images.githubusercontent.com/25957863/197451557-eecf0e34-75fc-4b30-b77e-52a23abca860.png)

