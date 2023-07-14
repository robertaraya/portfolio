FROM amazoncorretto:17-alpine
WORKDIR /app
ENV PORT=8080
EXPOSE 8080
COPY target/*.jar /app/portfolio.jar
ENTRYPOINT ["java","-jar","portfolio.jar"]