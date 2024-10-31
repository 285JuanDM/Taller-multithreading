# Caso de uso: `FileDownloader`

En el caso de uso se hizo simulador de descarga de archivos en Java, que permite al usuario seleccionar varios archivos para descargar de forma secuencial.

## Descripción

El programa presenta al usuario una lista de archivos disponibles y le permite seleccionar los archivos que desea descargar ingresando sus números. Las descargas se realizan en el orden en que el usuario las seleccionó, utilizando un `ExecutorService` para gestionar la ejecución de las tareas de descarga.

## Cómo funciona

1. El programa muestra una lista de archivos disponibles.
2. El usuario ingresa los números de los archivos que desea descargar (puede seleccionar múltiples archivos).
3. Las descargas se inician de forma secuencial, mostrando mensajes en la consola para indicar el inicio y la finalización de cada descarga.
4. El programa finaliza una vez que todas las descargas han sido completadas.
