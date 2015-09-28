package org.lol;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LolTest {

    @Test
    public void checkIfEnvSystemPropertyIsPassed() {
        String env = System.getProperty("env");
        assertNotNull(env);
    }

    @Test
    public void checkIfEnv2SystemPropertyIsPassed() {
        String env2 = System.getProperty("env2");
        assertNotNull(env2);
    }
}
