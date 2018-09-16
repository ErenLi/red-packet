package com.donkey.demo.service.impl;

import com.donkey.demo.dao.RedPacketMapper;
import com.donkey.demo.dao.UserRedPacketMapper;
import com.donkey.demo.domain.RedPacket;
import com.donkey.demo.domain.UserRedPacket;
import com.donkey.demo.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    /**
     * 失败
     */
    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId) {
        //获取红包信息
        RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);
        //当前小红包库存大于0
        if(redPacket.getStock() > 0){
//            redPacketMapper.decreaseRedPacket(redPacketId);
            int update = redPacketMapper.decreaseRedPacketForVersion(redPacketId, redPacket.getVersion());
            if(update == 0){
                return FAILED;
            }
            //生成抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("抢红包" + redPacketId);
            int result = userRedPacketMapper.grapRedPacket(userRedPacket);
            return result;
        }
        return FAILED;
    }

    @Override
    public int grapRedPacketForVersion(Long redPacketId, Long userId) {
        for(int i =0;i < 3;i++){
            RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);
            //当前小红包库存大于0
            if(redPacket.getStock() > 0){
                int update = redPacketMapper.decreaseRedPacketForVersion(redPacketId, redPacket.getVersion());
                if(update == 0){
                    continue;
                }
                //生成抢红包信息
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setUserId(userId);
                userRedPacket.setAmount(redPacket.getUnitAmount());
                userRedPacket.setNote("抢红包" + redPacketId);
                int result = userRedPacketMapper.grapRedPacket(userRedPacket);
                return result;
            }else {
                return FAILED;
            }
        }

        return FAILED;
    }
}
