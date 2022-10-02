package sooa.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import sooa.service.RegAndAuthService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Component
@Slf4j
public class AuthFilter extends GenericFilterBean {

    @Autowired
    private RegAndAuthService regAndAuthService;

    public AuthFilter(RegAndAuthService regAndAuthService) {
        this.regAndAuthService = regAndAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      /*  HttpServletRequest request = (HttpServletRequest) servletRequest;
        String content = request.getContentType();
        if(!content.contains("multipart"))
        {
            if (regAndAuthService.getCurrentUser() == null)
                throw new ServletException();
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

}