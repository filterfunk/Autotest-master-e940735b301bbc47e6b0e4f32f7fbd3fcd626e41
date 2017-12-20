package com.gisauto.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {

    protected CheckBox(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public WebElement getLabel(By by) {
        try {
            return getWrappedElement().findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void select() {
        if (!isSelected()) {
            getWrappedElement().click();
        }
    }

    public void deselect() {
        if (isSelected()) {
            getWrappedElement().click();
        }
    }

    public void set(boolean value) {
        if (value) {
            select();
        } else {
            deselect();
        }
    }
}
