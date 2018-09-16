package com.donkey.demo.rest;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;

/**
 * Created by qixin-lvxincao on 2018/3/3.
 */
public class ErrorController extends BasicErrorController {

    public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);

    }
}
