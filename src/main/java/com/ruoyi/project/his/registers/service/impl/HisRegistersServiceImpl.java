package com.ruoyi.project.his.registers.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.his.registers.mapper.HisRegistersMapper;
import com.ruoyi.project.his.registers.domain.HisRegisters;
import com.ruoyi.project.his.registers.service.IHisRegistersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 挂号记录Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Service
public class HisRegistersServiceImpl implements IHisRegistersService 
{
    @Autowired
    private HisRegistersMapper hisRegistersMapper;

    /**
     * 查询挂号记录
     * 
     * @param regId 挂号记录主键
     * @return 挂号记录
     */
    @Override
    public HisRegisters selectHisRegistersByRegId(Long regId)
    {
        return hisRegistersMapper.selectHisRegistersByRegId(regId);
    }

    /**
     * 查询挂号记录列表
     * 
     * @param hisRegisters 挂号记录
     * @return 挂号记录
     */
    @Override
    public List<HisRegisters> selectHisRegistersList(HisRegisters hisRegisters)
    {
        return hisRegistersMapper.selectHisRegistersList(hisRegisters);
    }

    /**
     * 新增挂号记录
     * 
     * @param hisRegisters 挂号记录
     * @return 结果
     */
    @Override
    public int insertHisRegisters(HisRegisters hisRegisters)
    {
        return hisRegistersMapper.insertHisRegisters(hisRegisters);
    }

    /**
     * 修改挂号记录
     * 
     * @param hisRegisters 挂号记录
     * @return 结果
     */
    @Override
    public int updateHisRegisters(HisRegisters hisRegisters)
    {
        return hisRegistersMapper.updateHisRegisters(hisRegisters);
    }

    /**
     * 批量删除挂号记录
     * 
     * @param regIds 需要删除的挂号记录主键
     * @return 结果
     */
    @Override
    public int deleteHisRegistersByRegIds(String regIds)
    {
        return hisRegistersMapper.deleteHisRegistersByRegIds(Convert.toStrArray(regIds));
    }

    /**
     * 删除挂号记录信息
     * 
     * @param regId 挂号记录主键
     * @return 结果
     */
    @Override
    public int deleteHisRegistersByRegId(Long regId)
    {
        return hisRegistersMapper.deleteHisRegistersByRegId(regId);
    }
}
