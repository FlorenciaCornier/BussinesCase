package config;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

import static net.serenitybdd.core.environment.WebDriverConfiguredEnvironment.getEnvironmentVariables;

public class GlobalConfig {
    public static final String HOME_PAGE_URL = EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("webdriver.base.url");
}
