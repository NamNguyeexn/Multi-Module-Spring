package com.logger.services;

import com.logger.utils.GsonParserUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LoggingService {
    private static final String REQUEST_ID = "request_id";

    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data
//                .append("\nLOGGING REQUEST BODY-----------------------------------\n")
//                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY REQUEST]: ").append("\n")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("\n")
//                .append("LOGGING REQUEST BODY-----------------------------------\n");
        ;
        log.info(data.toString());
    }

    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data
//                .append("\nLOGGING RESPONSE-----------------------------------\n")
//                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY RESPONSE]: ").append("\n")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("\n")
//                .append("LOGGING RESPONSE-----------------------------------\n");
        ;
        log.info(data.toString());
    }
}
