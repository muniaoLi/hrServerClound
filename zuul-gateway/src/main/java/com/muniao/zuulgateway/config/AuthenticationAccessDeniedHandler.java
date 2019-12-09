package com.muniao.zuulgateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muniao.zuulgateway.bean.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler
{
    /**
     * 权限不足时的处理
     * @param httpServletRequest
     * @param resp
     * @param e
     * @throws IOException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        RespBean error = RespBean.error("权限不足，请联系管理员!");
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }

}
