package com.gisauto.test.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.HashMap;

/**
 * Класс ConditionChecker служит для проверки множества условий.
 * <p>
 * При помощи методов addCheck... в HashMap<> добавляются условия по принципу:
 * <p>
 * ключ - ожидаемый результат, значение - фактический.
 * Метод assertAll() производит проверку HashMap<> на предмет отличия фактического результата от ожидаемого.
 *
 * @author Neradko Artsiom
 */
@Deprecated
public final class ConditionChecker {

    private static Logger logger = LogManager.getRootLogger();

    private static HashMap<String, String> conditions = new HashMap<String, String>(),
            failed = new HashMap<String, String>();

    /**
     * Добавляет условие в HashMap<>.
     *
     * @param excpectedResult ожидаемый результат.
     * @param actualResult    фактический результат.
     */
    public static void addCheckString(String excpectedResult, String actualResult) {
        conditions.put(excpectedResult, actualResult);
    }

    /**
     * Проводит проверку на предмет отличия фактического результата от ожидаемого.
     *
     * @return HashMap, в которой содержатся отличные от ожидаемого фактические результаты.
     */
    private static HashMap<String, String> check() {
        failed = new HashMap<String, String>();
        for (String s : conditions.keySet()) {
            if (!s.equals(conditions.get(s))) {
                failed.put(s, conditions.get(s));
            }
        }
        return failed;
    }

    /**
     * Проверяет наличие проваленных условий.
     *
     * @return true если нет отличий фактического результата от ожидаемого, false - если есть.
     */
    private static boolean isAnyFailed() {
        return check().isEmpty() ? false : true;
    }

    /**
     * Проверяет наличие проваленных условий. Если они есть, выводит в лог все проваленные и
     * вызывает AssertionError.
     */
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
