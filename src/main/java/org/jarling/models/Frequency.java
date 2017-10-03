package org.jarling.models;

/**
 * @author Nav Roudsari (nav@rzari.co.uk)
 */
public enum Frequency {

        DAILY("DAILY"),
        WEEKLY("WEEKLY"),
        MONTHLY("MONTHLY"),
        YEARLY("YEARLY");

        private final String value;

        Frequency(String value){ this.value = value; }

        public String getValue() {
                return this.value;
        }
}
