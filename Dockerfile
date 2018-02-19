FROM maven:3.5-jdk-8
COPY . /opt/app
WORKDIR /opt/app

CMD ["mvn", "clean", "test"]