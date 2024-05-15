package com.ruoyi.project.his.entry.service;

import java.util.List;
import com.ruoyi.project.his.entry.domain.HisWarehousingEntry;

/**
 * 入库单Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
public interface IHisWarehousingEntryService 
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
     * 批量删除入库单
     * 
     * @param entIds 需要删除的入库单主键集合
     * @return 结果
     */
    public int deleteHisWarehousingEntryByEntIds(String entIds);

    /**
     * 删除入库单信息
     * 
     * @param entId 入库单主键
     * @return 结果
     */
    public int deleteHisWarehousingEntryByEntId(Long entId);
}
