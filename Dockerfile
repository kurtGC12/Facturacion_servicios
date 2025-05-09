FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY target/facturacion_servicios-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_K5Y658KBCMFL1D1C /app/oracle_wallet
EXPOSE 8080


CMD [ "java", "-jar", "app.jar" ]