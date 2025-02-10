# Usa una imagen oficial de Python 3.13
FROM python:3.13

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del wrapper
COPY . .

# Instala las dependencias de Python (si tienes un requirements.txt)
# RUN pip install --no-cache-dir -r requirements.txt

# Comando para ejecutar el script Python
CMD ["python", "wrapper.py"]