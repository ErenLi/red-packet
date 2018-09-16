package com.donkey.demo.controller;

import com.donkey.demo.rest.Result;
import com.donkey.demo.rest.ResultGenerator;
import com.donkey.demo.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService;

    @RequestMapping(value = "/grapRedPacket", method = {RequestMethod.POST, RequestMethod.GET})
    public Result grapRedPacket(Long redPacketId, Long userId){
        //抢红包
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
        if(result > 0){
            return ResultGenerator.genFailResult("抢红包成功");
        }
        return ResultGenerator.genFailResult("抢红包失败");
    }


    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

}
