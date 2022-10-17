package io.github.cgglyle.boson.higgs.unity.controller;

import io.github.cgglyle.boson.higgs.unity.status.ClientErrorCode;
import io.github.cgglyle.boson.higgs.unity.status.ResultVo;
import io.github.cgglyle.boson.higgs.unity.status.SystemErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 404异常处理
 *
 * @author lyle
 * @since 2022/08/21
 */
@Slf4j
@RestController("/")
public class RequestExceptionHandler {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    // 404跳转
    @RequestMapping("404")
    public ResultVo<String> notFound() {
        log.error(ClientErrorCode.NOT_FOUNT.getMsg());
        return ResultVo.error(ClientErrorCode.NOT_FOUNT);
    }

    // 500跳转
    @RequestMapping("500")
    public ResultVo<String> sysError() {
        log.error(ClientErrorCode.NOT_FOUNT.getMsg());
        return ResultVo.error(SystemErrorCode.SYSTEM_ERROR);
    }
}
