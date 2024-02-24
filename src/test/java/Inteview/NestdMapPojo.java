package Inteview;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NestdMapPojo {

    private String firstname;
    private String lastName;
    private int id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
