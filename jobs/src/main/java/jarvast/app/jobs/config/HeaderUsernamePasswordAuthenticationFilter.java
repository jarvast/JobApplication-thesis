package jarvast.app.jobs.config;

import java.nio.charset.Charset;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class HeaderUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public HeaderUsernamePasswordAuthenticationFilter() {
        super();
        this.setFilterProcessesUrl("/**");
        this.setPostOnly(false);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        System.out.println("passorws");
        final String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            System.out.println("tömb" + values[0] + values[1]);
            return values[1];
        } else {
            return "asd";
        }

    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        System.out.println("usernéém");
        final String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            return values[0];
            // return request.getHeader("Authorization");
        } else {
            return "fffa";
        }
    }

}
