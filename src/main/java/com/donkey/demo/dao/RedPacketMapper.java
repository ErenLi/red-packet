package com.donkey.demo.dao;

import com.donkey.demo.domain.RedPacket;
import org.apache.ibatis.annotations.Param;

public interface RedPacketMapper {

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

    int decreaseRedPacketForVersion(@Param("id") Long id, @Param("version") Integer version);
}