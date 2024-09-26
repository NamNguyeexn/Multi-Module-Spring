package com.check.template_methods.DTO;

import com.check.models.UserState;
import com.check.template_methods.DTO.ENUM.RequestType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class RequestDTO {
    private HttpServletRequest request;
    private int userId;
    @Builder.Default
    private String message = null;
    private RequestType requestType;
    private UserState userState;
}
