package org.rizki.mufrizal.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 17:18
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.filter
 * @File PreFilterZuul
 */
public class PreFilterZuul extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreFilterZuul.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        if ("POST".equalsIgnoreCase(httpServletRequest.getMethod()) || "PUT".equalsIgnoreCase(httpServletRequest.getMethod())) {
            try {
                String body = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                LOGGER.info("Trace request body : {}", body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
