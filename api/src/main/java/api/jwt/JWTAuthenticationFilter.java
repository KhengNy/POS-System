package api.jwt;

/**
 * Created by khengny on 8/20/17.
 */
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

       HttpServletRequest tmp_request = (HttpServletRequest) request;
       HttpServletResponse tmp_response = (HttpServletResponse) response;
       tmp_response.setHeader("Access-Control-Allow-Origin", tmp_request.getHeader("Origin"));
       tmp_response.setHeader("Access-Control-Allow-Credentials", "true");
       tmp_response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");

        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest)request);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
}