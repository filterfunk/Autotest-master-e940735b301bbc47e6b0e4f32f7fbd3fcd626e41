FROM maven:3.5-jdk-8
COPY . /opt/app
WORKDIR /opt/app

ENV HOMEPAGE https://beta.gisauto.ru
ENV CHROME_PATH /opt/app/chromedriver

RUN chmod -R +x /opt/app/.allure/allure-2.0.1/bin \
    && apt-get update \
    && apt-get install -y chromium

CMD ["mvn", "clean", "test"]