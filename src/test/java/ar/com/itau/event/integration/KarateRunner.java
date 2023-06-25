package ar.com.itau.event.integration;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {

    @Karate.Test
    public Karate execute() {
        return new Karate().tags("integration").path("src/test/resources/integration/feature");
    }

}
