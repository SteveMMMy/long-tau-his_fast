package com.ruoyi.project.his.inventory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.his.inventory.mapper.HisInventoryMapper;
import com.ruoyi.project.his.inventory.domain.HisInventory;
import com.ruoyi.project.his.inventory.service.IHisInventoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 库存管理Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
@Service
public class HisInventoryServiceImpl implements IHisInventoryService 
{
    @Autowired
    private HisInventoryMapper hisInventoryMapper;

    /**
     * 查询库存管理
     * 
     * @param invId 库存管理主键
     * @return 库存管理
     */
    @Override
    public HisInventory selectHisInventoryByInvId(Long invId)
    {
        return hisInventoryMapper.selectHisInventoryByInvId(invId);
    }

    /**
     * 查询库存管理列表
     * 
     * @param hisInventory 库存管理
     * @return 库存管理
     */
    @Override
    public List<HisInventory> selectHisInventoryList(HisInventory hisInventory)
    {
        return hisInventoryMapper.selectHisInventoryList(hisInventory);
    }

    /**
     * 新增库存管理
     * 
     * @param hisInventory 库存管理
     * @return 结果
     */
    @Override
    public int insertHisInventory(HisInventory hisInventory)
    {
        return hisInventoryMapper.insertHisInventory(hisInventory);
    }

    /**
     * 修改库存管理
     * 
     * @param hisInventory 库存管理
     * @return 结果
     */
    @Override
    public int updateHisInventory(HisInventory hisInventory)
    {
        return hisInventoryMapper.updateHisInventory(hisInventory);
    }

    /**
     * 批量删除库存管理
     * 
     * @param invIds 需要删除的库存管理主键
     * @return 结果
     */
    @Override
    public int deleteHisInventoryByInvIds(String invIds)
    {
        return hisInventoryMapper.deleteHisInventoryByInvIds(Convert.toStrArray(invIds));
    }

    /**
     * 删除库存管理信息
     * 
     * @param invId 库存管理主键
     * @return 结果
     */
    @Override
    public int deleteHisInventoryByInvId(Long invId)
    {
        return hisInventoryMapper.deleteHisInventoryByInvId(invId);
    }
}
