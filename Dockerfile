# Java 17 için OpenJDK imajını kullan
FROM openjdk:17-jdk-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Proje dosyalarını konteynıra kopyala
COPY . .

# Maven wrapper'ı çalıştırılabilir yap
RUN chmod +x ./mvnw

# Maven kullanarak projeyi build et
RUN ./mvnw clean package -DskipTests

# Uygulamayı çalıştır
CMD ["java", "-jar", "target/beauty-salon-0.0.1-SNAPSHOT.jar"]
