package uy.interfase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Milver Flores Acevedo
 * @since 1.0
 */
@Getter
@Setter
public class TokenDto {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;
}
