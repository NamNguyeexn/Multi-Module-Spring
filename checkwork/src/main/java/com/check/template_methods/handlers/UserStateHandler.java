package com.check.template_methods.handlers;

import com.check.template_methods.DTO.RequestDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserStateHandler {
    UserStateChain handler(RequestDTO request);
}
