package com.example.ketangpai.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 名称
 * @date 2022/8/31 10:48
 */
public class ResponseUtil {

    public static void returnJson(HttpServletResponse response, Object obj) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(obj);
            writer.print(json);

        } catch (IOException e) {

        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
