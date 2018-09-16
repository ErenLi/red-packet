package com.donkey.demo.service.impl;

import com.donkey.demo.dao.RedPacketMapper;
import com.donkey.demo.domain.RedPacket;
import com.donkey.demo.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return redPacketMapper.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return redPacketMapper.decreaseRedPacket(id);
    }
}
