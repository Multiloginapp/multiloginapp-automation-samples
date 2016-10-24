package com.multiloginappp.automationsamples;

import com.multiloginapp.client.webdriver.MultiloginappApi;
import org.junit.Assert;
import org.junit.Test;

public class ProfileAutomationSamples {

    static final int mlaClientPort = 35000;

    @Test
    public void testCreateProfile() {
        createProfile();
    }

    public String createProfile() {
        //initialize
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create profile
        //1 - FIREFOX, 2 - CHROME, 3 - OPERA, 4 - STEALTH_FOX
        String profileJson = "{name: 'profile_name', browserType: 2}";
        String profileId = api.createProfile(profileJson);
        Assert.assertNotNull(profileId);
        return profileId;
    }

    @Test
    public void profileData() {
        // initialize
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create profile
        String profileId = createProfile();
        // get profile data
        String dataJson = api.getProfileData(profileId);
        Assert.assertNotNull(dataJson);
    }

    @Test
    public void profileRemove() {
        // initialize
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create profile
        String profileId = createProfile();
        // remove profile
        boolean res = api.removeProfile(profileId);
        Assert.assertTrue(res);
    }

    @Test
    public void testStartProfile() {
        startProfile();
    }

    public String startProfile() {
        // initialize
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create profile
        String profileId = createProfile();
        // start profile
        boolean res = api.startProfile(profileId);
        Assert.assertTrue(res);
        return profileId;
    }

    @Test
    public void stopProfile() {
        MultiloginappApi api = MultiloginappApi.create(mlaClientPort);
        // create & start profile
        String profileId = startProfile();
        // stop profile
        boolean resStop = api.stopProfile(profileId);
        Assert.assertTrue(resStop);
    }
}
