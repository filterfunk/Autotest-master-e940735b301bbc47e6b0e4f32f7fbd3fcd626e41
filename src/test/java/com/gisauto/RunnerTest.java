package com.gisauto;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/gisauto/features",    //путь к папке с .feature файлами
        glue = {"com.gisauto.stepdefs","com.gisauto.hooks"},//пакет, в котором находятся классы с реализацией шагов и «хуков»
        tags = "@1-25",                                      //фильтр запускаемых тестов по тэгам
        dryRun = false,                                     // если true, то сразу после запуска теста фреймворк проверяет, все ли шаги теста разработаны, если нет, то выдает предупреждение
        strict = false,                                     //если true, то при встрече неразработанного шага тест остановится с ошибкой
        snippets = SnippetType.UNDERSCORE                   //указывает в каком формате фреймворк будет предлагать шаблон для нереализованных шагов
)
public class RunnerTest {

}