package com.ruoyi.project.his.entry.mapper;

import java.util.List;
import com.ruoyi.project.his.entry.domain.HisWarehousingEntry;
import com.ruoyi.project.his.entry.domain.HisEntrySchedules;

/**
 * 入库单Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
public interface HisWarehousingEntryMapper 
{
    /**
     * 查询入库单
     * 
     * @param entId 入库单主键
     * @return 入库单
     */
    public HisWarehousingEntry selectHisWarehousingEntryByEntId(Long entId);

    /**
     * 查询入库单列表
     * 
     * @param hisWarehousingEntry 入库单
     * @return 入库单集合
     */
    public List<HisWarehousingEntry> selectHisWarehousingEntryList(HisWarehousingEntry hisWarehousingEntry);

    /**
     * 新增入库单
     * 
     * @param hisWarehousingEntry 入库单
     * @return 结果
     */
    public int insertHisWarehousingEntry(HisWarehousingEntry hisWarehousingEntry);

    /**
     * 修改入库单
     * 
     * @param hisWarehousingEntry 入库单
     * @return 结果
     */
    public int updateHisWarehousingEntry(HisWarehousingEntry hisWarehousingEntry);

    /**
     * 删除入库单
     * 
     * @param entId 入库单主键
     * @return 结果
     */
    public int deleteHisWarehousingEntryByEntId(Long entId);

    /**
     * 批量删除入库单
     * 
     * @param entIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisWarehousingEntryByEntIds(String[] entIds);

    /**
     * 批量删除入库单明细
     * 
     * @param entIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisEntrySchedulesByEntIds(String[] entIds);
    
    /**
     * 批量新增入库单明细
     * 
     * @param hisEntrySchedulesList 入库单明细列表
     * @return 结果
     */
    public int batchHisEntrySchedules(List<HisEntrySchedules> hisEntrySchedulesList);
    

    /**
     * 通过入库单主键删除入库单明细信息
     * 
     * @param entId 入库单ID
     * @return 结果
     */
    public int deleteHisEntrySchedulesByEntId(Long entId);
}
