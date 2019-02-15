package org.rizki.mufrizal.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 17:44
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.filter
 * @File ErrorFilterZuul
 */
public class ErrorFilterZuul extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorFilterZuul.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().containsKey("error.status_code");
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.get("error.exception");

            if (e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException) e;
                LOGGER.error("Zuul failure detected: " + zuulException.getMessage(), zuulException);

                ctx.remove("error.status_code");

                ctx.setResponseBody("Overriding Zuul Exception Body");
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(500);
            }
        } catch (Exception ex) {
            LOGGER.error("Exception filtering in custom error filter", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
