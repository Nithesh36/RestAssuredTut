package restAssuredRevise.pojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirstLastName {
    @JsonProperty("firstname")
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    String firstname;

    @JsonProperty("lastName")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String lastName;
}
