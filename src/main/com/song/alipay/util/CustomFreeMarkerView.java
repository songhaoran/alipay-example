package com.song.alipay.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Song on 2017/7/20.
 */
public class CustomFreeMarkerView extends FreeMarkerView {

    private static String documentDomain;

    static{
        try {
            ClassPathResource resource = new ClassPathResource("resource.properties");
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            documentDomain = properties.getProperty("documentDomain");
        } catch (Exception e) {
        }
    }

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String appContext = request.getContextPath();
        StringBuilder basePath = new StringBuilder();
        basePath.append(request.getScheme()).append("://");
        basePath.append(request.getServerName());
        if (request.getServerPort() != 80) {
            basePath.append(":").append(request.getServerPort());
        }

        basePath.append(appContext);
        model.put("base", basePath.toString());
        model.put("documentDomain", documentDomain);
        super.exposeHelpers(model, request);
    }
}
