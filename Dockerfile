FROM maven:latest
COPY . /opt/app
WORKDIR /opt/app

ENV HOMEPAGE https://beta.gisauto.ru
ENV CHROME_PATH chromedriver

RUN apt-get -qq update \
    && apt-get -qq install -y software-properties-common

RUN apt-add-repository ppa:qameta/allure \
    && apt-get -qq update \
    && apt-get -y install allure-commandline



CMD ["mvn", "clean", "test"]
CMD ["allure", "serve", "/opt/app/target/allure-results"]