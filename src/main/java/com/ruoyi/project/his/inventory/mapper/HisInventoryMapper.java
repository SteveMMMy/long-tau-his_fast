package com.ruoyi.project.his.inventory.mapper;

import java.util.List;
import com.ruoyi.project.his.inventory.domain.HisInventory;

/**
 * 库存管理Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
public interface HisInventoryMapper 
{
    /**
     * 查询库存管理
     * 
     * @param invId 库存管理主键
     * @return 库存管理
     */
    public HisInventory selectHisInventoryByInvId(Long invId);

    /**
     * 查询库存管理列表
     * 
     * @param hisInventory 库存管理
     * @return 库存管理集合
     */
    public List<HisInventory> selectHisInventoryList(HisInventory hisInventory);

    /**
     * 新增库存管理
     * 
     * @param hisInventory 库存管理
     * @return 结果
     */
    public int insertHisInventory(HisInventory hisInventory);

    /**
     * 修改库存管理
     * 
     * @param hisInventory 库存管理
     * @return 结果
     */
    public int updateHisInventory(HisInventory hisInventory);

    /**
     * 删除库存管理
     * 
     * @param invId 库存管理主键
     * @return 结果
     */
    public int deleteHisInventoryByInvId(Long invId);

    /**
     * 批量删除库存管理
     * 
     * @param invIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisInventoryByInvIds(String[] invIds);
}
