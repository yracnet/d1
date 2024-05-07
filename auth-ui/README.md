# Instrucciones para construir y ejecutar la imagen Docker de auth-ui

A continuación, se detallan los pasos necesarios para construir, ejecutar y trabajar con la imagen Docker de auth-ui.

## Construir la imagen Docker

Para construir la imagen Docker de auth-ui, utiliza el siguiente comando en el directorio raíz del proyecto:

```bash
docker build -t auth-ui:latest .
```

## Ejecutar la imagen Docker

Para ejecutar la imagen Docker de auth-ui y mapear el puerto 8081 del host al puerto 80 del contenedor, utiliza el siguiente comando:

```bash
docker run -p 8081:80 auth-ui:latest
```

## Subir la imagen Docker a Docker Hub

Si deseas subir la imagen Docker a Docker Hub para que esté disponible públicamente, sigue estos pasos:

1. Etiqueta la imagen con tu nombre de usuario de Docker Hub y el nombre del repositorio (puedes cambiar `yracnet` por tu nombre de usuario de Docker Hub si es diferente):
   ```bash
   docker tag auth-ui:latest yracnet/auth-ui:latest
   ```
2. Sube la imagen etiquetada a Docker Hub:
   ```bash
   docker push yracnet/auth-ui:latest
   ```

## Ejecutar la imagen Docker desde Docker Hub

Una vez que la imagen está disponible en Docker Hub, puedes ejecutarla en cualquier máquina que tenga Docker instalado utilizando el siguiente comando:

```bash
docker run --name auth-ui -d -p 8081:80 yracnet/auth-ui:latest
```

## Ejecutar la imagen Docker con un archivo de configuración personalizado

Si necesitas proporcionar un archivo de configuración personalizado al contenedor Docker, puedes montar el archivo como un volumen utilizando el siguiente comando:

```bash
docker run --name auth-ui -d -p 8082:80 -v /ruta/al/archivo/provider.json:/site/provider.json yracnet/auth-ui:latest
```

Asegúrate de reemplazar `/ruta/al/archivo/provider.json` con la ruta completa al archivo de configuración en tu máquina host.
