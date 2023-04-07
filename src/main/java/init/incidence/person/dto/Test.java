package init.incidence.person.dto;

import init.incidence.comun.validation.annotation.CondicionalField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@CondicionalField(selected = "request", values = {"POST"}, required = {"host", "user"})
@CondicionalField(selected = "request", values = {"GET"}, required = {"password", "port"})
@AllArgsConstructor
public class Test {

    @NotBlank
    private String request;

    public Test(String host, String user, String password, String port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    private String host;
    private String user;
    private String password;
    private String port;

}
