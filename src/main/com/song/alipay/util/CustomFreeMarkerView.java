package com.song.alipay.util;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Song on 2017/7/20.
 */
public class CustomFreeMarkerView extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String appContext = request.getContextPath();
        StringBuilder basePath = new StringBuilder();
        basePath.append(request.getScheme()).append("://");
        basePath.append(request.getServerName());
        if(request.getServerPort() != 80) {
            basePath.append(":").append(request.getServerPort());
        }

        basePath.append(appContext);
        model.put("base", basePath.toString());
        super.exposeHelpers(model, request);
    }
}
