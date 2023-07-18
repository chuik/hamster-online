package com.hamster.controller;

import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import com.hamster.utils.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/qrCode")
public class QRCodeController {

    @RequestMapping("/getCode")
    @ResponseBody
    public ResultJson getQr(HttpServletResponse response) {
        ResultJson resultJson = ResultJson.success();

        try {
            QRCodeUtil.createCodeToOutputStream("https://www.baidu.com", response.getOutputStream());
        } catch (IOException e) {
            ResultJson.error(RespBeanEnum.ERROR);
        }
        return resultJson;
    }
}
