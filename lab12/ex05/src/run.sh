#!/bin/bash

# Verifica se o número correto de argumentos foi fornecido
if [ "$#" -lt 1 ] || [ "$#" -gt 2 ]; then
  echo "Usage: $0 [-r] <directory>"
  exit 1
fi

# Compila os arquivos Java
javac SizeCalculator.java SizeOf.java

# Cria o arquivo JAR executável
jar cfe sizeOf.jar SizeOf SizeCalculator.class SizeOf.class

# Executa o programa Java com os argumentos fornecidos
if [ "$#" -eq 2 ] && [ "$1" == "-r" ]; then
  java -jar sizeOf.jar -r "$2"
else
  java -jar sizeOf.jar "$1"
fi

rm SizeCalculator.class SizeOf.class sizeOf.jar
