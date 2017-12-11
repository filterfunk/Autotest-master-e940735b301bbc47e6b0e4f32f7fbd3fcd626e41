package com.gisauto.utils;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.Assert;

import java.util.HashMap;

public final class ConditionChecker {

    //TODO: 11.12.2017 artem.neradko - написать JavaDoc для всех методов и классов
    private static Logger logger = LogManager.getRootLogger();

    private static HashMap<String, String> conditions = new HashMap<String, String>(),
            failed = new HashMap<String, String>();

    public static void addCheckString(String excpectedResult, String actualResult) {
        conditions.put(excpectedResult, actualResult);
    }

    private static HashMap<String, String> check() {
        failed = new HashMap<String, String>();
        for (String s : conditions.keySet()) {
            if (!s.equals(conditions.get(s))) {
                failed.put(s, conditions.get(s));
            }
        }
        return failed;
    }

    private static boolean isAnyFailed() {
        return check().isEmpty() ? false : true;
    }

    public static void assertAll() {
        if (isAnyFailed()) {
            try {
                for (String s : failed.keySet()) {
                    try {
                        Assert.assertEquals(s, failed.get(s));
                    } catch (AssertionError ex) {
                        logger.error("Assertion error: " + ex.getStackTrace()[0] + '\n'
                                + "Ожидаемый результат: " + s
                                + '\n' + "Фактический результат: " + failed.get(s) + '\n');
                    }
                }
            } finally {
                throw new AssertionError("Test failed!");
            }

        }
    }

}
