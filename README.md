# GisAuto Autotest :blue_car:
Проект предназначен для написания, запуска и получения отчетов автотестов.

## Требования
* Для успешной установки проекта и его использования необходимо установить:
    * [IntelliJ IDEA](https://www.jetbrains.com/help/idea/install-and-set-up-intellij-idea.html)
    * [MVN](https://maven.apache.org/install.html)
    * [Java (минимум 8 версия)](https://java.com/ru/download/)
    * [FireFox driver](https://github.com/mozilla/geckodriver/releases) или [Chrome driver](https://sites.google.com/a/chromium.org/chromedriver/)
    * [Docker](https://docs.docker.com/get-started/)
    
* ## Компоненты:
* Тестовый фреймворк - [JUnit4](https://github.com/junit-team/junit4)
* Фреймворк автотестов - [Selenium WebDriver](https://github.com/SeleniumHQ/selenium)
* Логгер - [log4j](https://github.com/apache/logging-log4j2)
* Отчеты - [Yandex Allure](https://github.com/allure-framework/allure2)
* BDD - [Cucumber](https://cucumber.io/)
* CSS регресс - [Gemini](https://github.com/gemini-testing/gemini)

## Установка и запуск
* Для того чтобы запустить проект и начать прогон тестов необходимо:
    * Склонировать проект:
     `git clone ssh://git@gitlab.gisauto.ru:2222/Nao/Autotest.git`
    * Открыть проект в IntelliJIDEA
    * Создать Maven-конфигурацию - clean test, задать переменные среды jvm: <br>
        * HOMEPAGE - адрес домашней страницы (beta или бой) <br>
        * PRICEFOLDER - каталог, в котором лежат прайсы
        * TARGET_BROWSER - браузер, в котором будут запускаться тесты
        * FIREFOX/CHROME_PATH - путь к FireFox/Chrome драйверу
    * Запустить проект в IDE (Shift + F10)

## Генерация отчетов
* Для того чтобы сгенерировать отчет прогона тестов необходимо:
    * В директории проекта выполнить команду: `allure serve path/to/allure-results` <br>
После ввода команды начнется формироваться отчет. По завершение формирования <br>
автоматически откроется страница Allure с отчетом.

## Gemini
* Используется для проведения регрессионого тестирования весртки.<br>
* Gemini берет эталонные скриншоты и сравнивает их с текущими, если между ними<br>
есть разница, то она выделяется заданным в конфиг-файле цветом. <br><br>

* Для установки gemini необходимо проделать следующее: <br>
    * `npm install -g gemini
npm install -g html-reporter`
    * Скорее всего придется установить/обновить nodejs:<br>
`sudo n stable`
и повторить первый шаг.
    * Установить PhantomJS: <br>
`sudo apt-get install phantomjs` <br>

* Gemini хранит в своей директории эталонные скриншоты элементов, описанных
в тест-кейсах. Чтобы сделать эталонные скриншоты необходимо выполнить команду: <br>
`gemini update` - данная команда создает скриншоты и заменяет старые, если они есть.<br>

* Для запуска тестов вызывается команда:<br>
`gemini test` - проходит все тест-кейсы, если есть отличия текущего скриншота от <br>
эталонного, то тест счиатется провальным.<br>

* Для генерации html-отчета используется плагин html-reporter/gemini, который <br>
автоматически генерирует html отчет о пройденых тестах, прикладывая скриншоты: <br>
фактический, ожидаемый и разница (отображает различия между скриншотами)<br>

* Все конфигурации хранятся в gemini.js и gemini.yml <br>




#### Автор:
@artem.neradko

