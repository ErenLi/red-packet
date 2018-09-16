package com.donkey.demo.service;

import com.donkey.demo.domain.RedPacket;

public interface RedPacketService {

    /**
     * 获取红包信息
     * @param id
     * @return
     */
    RedPacket getRedPacket(Long id);

    /**
     * 扣减红包信息
     * @param id
     * @return
     */
    int decreaseRedPacket(Long id);
}
