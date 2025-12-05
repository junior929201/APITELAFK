# Imagem de build (JDK)
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copia todo o projeto
COPY . .

# Dá permissão para o Maven Wrapper rodar
RUN chmod +x mvnw

# Empacota a aplicação (gera o .jar)
RUN ./mvnw clean package -DskipTests

# Imagem final (JRE)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia o jar compilado
COPY --from=builder /app/target/*.jar app.jar

# Render define a porta na variável PORT
ENV PORT=8080
EXPOSE 8080

# Comando para iniciar o servidor
CMD ["java", "-jar", "app.jar"]
