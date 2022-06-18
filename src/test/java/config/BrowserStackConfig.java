package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/browserstackDriver.properties"
})
public interface BrowserStackConfig extends Config {
    String username();

    String access_key();

    String project();

    String build();

    String name();

    String app();

    String device();

    String osVersion();

    String baseUrl();

}