package com.ruoyi.project.test.registers.mapper;

import java.util.List;
import com.ruoyi.project.test.registers.domain.HisRegisters;

/**
 * 挂号记录Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-04-17
 */
public interface HisRegistersMapper 
{
    /**
     * 带患者信息的挂号记录查询
     *
     * @param hisRegisters 挂号记录主键
     * @return 挂号记录（带有患者信息）
     */
    List<HisRegisters> selectPatientsRegisters(HisRegisters hisRegisters);

    /**
     * 查询挂号记录
     * 
     * @param regId 挂号记录主键
     * @return 挂号记录
     */
    public HisRegisters selectHisRegistersByRegId(Long regId);

    /**
     * 查询挂号记录列表
     * 
     * @param hisRegisters 挂号记录
     * @return 挂号记录集合
     */
    public List<HisRegisters> selectHisRegistersList(HisRegisters hisRegisters);

    /**
     * 新增挂号记录
     * 
     * @param hisRegisters 挂号记录
     * @return 结果
     */
    public int insertHisRegisters(HisRegisters hisRegisters);

    /**
     * 修改挂号记录
     * 
     * @param hisRegisters 挂号记录
     * @return 结果
     */
    public int updateHisRegisters(HisRegisters hisRegisters);

    /**
     * 删除挂号记录
     * 
     * @param regId 挂号记录主键
     * @return 结果
     */
    public int deleteHisRegistersByRegId(Long regId);

    /**
     * 批量删除挂号记录
     * 
     * @param regIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisRegistersByRegIds(String[] regIds);
}
