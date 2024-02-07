# Stage 1: Checkout the code from the repository
FROM alpine/git AS git
WORKDIR /app
RUN git clone https://github.com/kilaruu/Train-Ticket-Reservation-System.git .

# Stage 2: Build the war file
FROM maven:amazoncorretto AS build
WORKDIR /app
COPY --from=git /app /app
RUN mvn clean install

# Stage 3: Deploy the war file to a Tomcat environment
FROM adhig93/tomcat-conf AS deploy
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/
