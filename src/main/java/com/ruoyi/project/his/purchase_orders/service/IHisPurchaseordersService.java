package com.ruoyi.project.his.purchase_orders.service;

import java.util.List;
import com.ruoyi.project.his.purchase_orders.domain.HisPurchaseorders;

/**
 * 采购订单Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface IHisPurchaseordersService 
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
     * 批量删除采购订单
     * 
     * @param purIds 需要删除的采购订单主键集合
     * @return 结果
     */
    public int deleteHisPurchaseordersByPurIds(String purIds);

    /**
     * 删除采购订单信息
     * 
     * @param purId 采购订单主键
     * @return 结果
     */
    public int deleteHisPurchaseordersByPurId(Long purId);
}
