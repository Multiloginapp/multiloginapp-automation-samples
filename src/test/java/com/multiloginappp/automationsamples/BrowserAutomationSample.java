package com.multiloginappp.automationsamples;

import com.multiloginapp.client.webdriver.MultiLoginAppWebDriver;
import com.multiloginapp.client.webdriver.MultiloginappApi;
import org.junit.Assert;
import org.junit.Test;

public class BrowserAutomationSample {

    static final int mlaClientPort = 35000;

    @Test(timeout = 3 * 60 * 1000)
    public void automateBrowserBasic() {
        //TODO replace with existing profile Id
        String profileId = "";
        //start session
        MultiLoginAppWebDriver webDriver = MultiLoginAppWebDriver.create(mlaClientPort, profileId);
        //perform automation
        webDriver.get("http://multiloginapp.com/");
        Assert.assertTrue(webDriver.getPageSource().contains("Multiloginapp"));
    }

    @Test(timeout = 3 * 60 * 1000)
    public void automateChrome() {
        createProfileAndAutomate(2);
    }

    @Test(timeout = 3 * 60 * 1000)
    public void automateFirefox() {
        createProfileAndAutomate(1);
    }

    @Test(timeout = 3 * 60 * 1000)
    public void automateOpera() {
        createProfileAndAutomate(3);
    }

    @Test(timeout = 3 * 60 * 1000)
    public void automateStealthFox() {
        createProfileAndAutomate(4);
    }

    private void createProfileAndAutomate(Integer browserType) {
        // initialize
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create profile
        String json = "{name:'profile name', browserType: " + browserType + "}";
        String profileId = api.createProfile(json);
        Assert.assertNotNull(profileId);
        // start profile
        boolean res = api.startProfile(profileId);
        Assert.assertTrue(res);
        // get webdriver
        MultiLoginAppWebDriver webDriver = MultiLoginAppWebDriver.create(api, profileId);
        //perform automation
        webDriver.get("http://multiloginapp.com/");
        Assert.assertTrue(webDriver.getPageSource().contains("Multiloginapp"));
    }

}
