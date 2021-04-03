package com.chc853.book.springboot.web;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile_search(){
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile_not_first_search(){
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile_not_default_search(){
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }
}
