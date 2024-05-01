package com.ruoyi.project.his.purchase_orders.mapper;

import java.util.List;
import com.ruoyi.project.his.purchase_orders.domain.HisPurchaseorders;
import com.ruoyi.project.his.purchase_orders.domain.HisOrdersSchedules;

/**
 * 采购订单Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface HisPurchaseordersMapper 
{
    /**
     * 查询采购订单
     * 
     * @param purId 采购订单主键
     * @return 采购订单
     */
    public HisPurchaseorders selectHisPurchaseordersByPurId(Long purId);

    /**
     * 查询采购订单列表
     * 
     * @param hisPurchaseorders 采购订单
     * @return 采购订单集合
     */
    public List<HisPurchaseorders> selectHisPurchaseordersList(HisPurchaseorders hisPurchaseorders);

    /**
     * 新增采购订单
     * 
     * @param hisPurchaseorders 采购订单
     * @return 结果
     */
    public int insertHisPurchaseorders(HisPurchaseorders hisPurchaseorders);

    /**
     * 修改采购订单
     * 
     * @param hisPurchaseorders 采购订单
     * @return 结果
     */
    public int updateHisPurchaseorders(HisPurchaseorders hisPurchaseorders);

    /**
     * 删除采购订单
     * 
     * @param purId 采购订单主键
     * @return 结果
     */
    public int deleteHisPurchaseordersByPurId(Long purId);

    /**
     * 批量删除采购订单
     * 
     * @param purIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPurchaseordersByPurIds(String[] purIds);

    /**
     * 批量删除采购订单明细
     * 
     * @param purIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisOrdersSchedulesByPurIds(String[] purIds);
    
    /**
     * 批量新增采购订单明细
     * 
     * @param hisOrdersSchedulesList 采购订单明细列表
     * @return 结果
     */
    public int batchHisOrdersSchedules(List<HisOrdersSchedules> hisOrdersSchedulesList);
    

    /**
     * 通过采购订单主键删除采购订单明细信息
     * 
     * @param purId 采购订单ID
     * @return 结果
     */
    public int deleteHisOrdersSchedulesByPurId(Long purId);
}
