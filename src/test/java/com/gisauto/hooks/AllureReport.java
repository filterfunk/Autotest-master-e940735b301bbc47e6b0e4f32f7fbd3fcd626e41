package com.gisauto.hooks;

import com.gisauto.utils.Driver;
import gherkin.formatter.model.Result;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;

public class AllureReport extends AllureReporter {

    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) {
            embedding("image/png", saveScreenshot());
        }
        super.result(result);
    }

    @Attachment(type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}