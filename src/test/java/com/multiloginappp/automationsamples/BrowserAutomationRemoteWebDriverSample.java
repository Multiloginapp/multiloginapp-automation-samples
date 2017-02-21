package com.multiloginappp.automationsamples;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class BrowserAutomationRemoteWebDriverSample {

    @Test(timeout = 3 * 60 * 1000)
    public void simpleTest() throws Exception {
        //TODO replace with existing profile Id
        String profileId = "xxx";
        int mlaClientPort = 35000;

        URI url = new URIBuilder("http://127.0.0.1:" + mlaClientPort + "/api/v1/webdriver").build();

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("multiloginapp-profileId", profileId);

        RemoteWebDriver driver = new RemoteWebDriver(url.toURL(), dc);

        //perform automation
        driver.get("http://multiloginapp.com/");
        Assert.assertTrue(driver.getPageSource().contains("Multiloginapp"));
        driver.quit();
    }

}
