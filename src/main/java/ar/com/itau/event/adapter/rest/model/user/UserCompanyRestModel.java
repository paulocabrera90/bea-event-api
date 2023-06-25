package ar.com.itau.event.adapter.rest.model.user;

import ar.com.itau.event.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCompanyRestModel {

    private String id;
    private String state;
    private String role;

    public User.Company toDomain() {
        return User.Company.builder()
                .id(id)
                .state(state)
                .role(role)
                .build();
    }

}
