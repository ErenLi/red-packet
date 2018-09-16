package com.donkey.demo.service;


public interface UserRedPacketService {

    int grapRedPacket(Long redPacketId, Long userId);

    int grapRedPacketForVersion(Long redPacketId, Long userId);

}


