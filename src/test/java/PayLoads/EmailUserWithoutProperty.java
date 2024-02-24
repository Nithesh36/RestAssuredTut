package PayLoads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailUserWithoutProperty {
    private String Email;
    private  String pwd;

    @JsonProperty("mail")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }


@JsonProperty("pwd")
    public String getpwd() {
        return pwd;
    }

    public void setpwd(String userName) {
        this.pwd = userName;
    }


}
