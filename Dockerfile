FROM openjdk:8
ADD target/teksAnlyzer.jar teksAnlyzer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "teksAnlyzer.jar"]