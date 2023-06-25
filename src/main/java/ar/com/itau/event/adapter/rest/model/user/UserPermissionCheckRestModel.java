package ar.com.itau.event.adapter.rest.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPermissionCheckRestModel {
    private Boolean result;
}
