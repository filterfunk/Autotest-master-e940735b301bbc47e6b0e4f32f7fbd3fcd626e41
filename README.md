# GisAuto Autotest :blue_car:
Проект предназначен для написания, запуска и получения отчетов автотестов.

## Требования
* Для успешной установки проекта и его использования необходимо установить:
    * [MVN](https://maven.apache.org/install.html)
    * [Java (минимум 8 версия)](https://java.com/ru/download/)
    * [FireFox driver](https://github.com/mozilla/geckodriver/releases)
    
* ## Компоненты:
* Тестовый фреймворк - [JUnit4](https://github.com/junit-team/junit4)
* Фреймворк автотестов - [Selenium WebDriver](https://github.com/SeleniumHQ/selenium)
* Логгер - [log4j](https://github.com/apache/logging-log4j2)
* Отчеты - [Yandex Allure](https://github.com/allure-framework/allure2)
* BDD - [Cucumber](https://cucumber.io/)

## Установка и запуск
* Для того чтобы запустить проект и начать прогон тестов необходимо:
    * Склонировать проект:
     `git clone ssh://git@gitlab.gisauto.ru:2222/Nao/Autotest.git`
    * Открыть проект в IntelliJIDEA
    * Создать Maven-конфигурацию - clean test, задать переменные среды jvm: <br>
        * HOMEPAGE - адрес домашней страницы (beta или бой) <br>
        * PRICEFOLDER - каталог, в котором лежат прайсы
    * Запустить проект в IDE либо выыполнив команду: `mvn clean test` в директории проекта

## Генерация отчетов
* Для того чтобы сгенерировать отчет прогона тестов необходимо:
    * В директории проекта выполнить команду: `allure serve path/to/allure-results` <br>
После ввода команды начнется формироваться отчет. По завершение формирования <br>
автоматически откроется страница Allure с отчетом.

#### Авторы:
@artem.neradko <br>
@Nao

