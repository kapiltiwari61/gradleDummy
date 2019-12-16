package com.specsavers.core;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

public class Properties {

    private static EnvironmentVariables vars = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();

    private static Map<String, String> env = System.getenv();

    public static String getUAT5BaseURL(){return getProperty("webdriver.base.url.uat5");}

    private static String getProperty(String property) {
        return vars.getProperty(property);
    }

    public static String experitestKey() { return getProperty("experitestKey");
    }

    public static String SASAWSVersion(){return getProperty("SASAWSVersion");}

    public static String SASAWSKey(){return getProperty("SASAWSKey");}
    public static String expBrowser() {return getProperty("serenity.expBrowser");}

}
