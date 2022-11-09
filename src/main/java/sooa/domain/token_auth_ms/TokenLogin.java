package sooa.domain.token_auth_ms;

import lombok.Data;

@Data
public class TokenLogin {
    private String token;
    private String user;
    private String creation;
    private String expires;

    public TokenLogin() {
        super();
    }

}
