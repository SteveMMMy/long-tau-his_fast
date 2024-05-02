package com.ruoyi.project.his.purchase.service;

import java.util.List;
import com.ruoyi.project.his.purchase.domain.HisPurchaseOrders;

/**
 * 采购订单Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface IHisPurchaseOrdersService 
{
    /**
     * 查询采购订单
     * 
     * @param purId 采购订单主键
     * @return 采购订单
     */
    public HisPurchaseOrders selectHisPurchaseOrdersByPurId(Long purId);

    /**
     * 查询采购订单列表
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 采购订单集合
     */
    public List<HisPurchaseOrders> selectHisPurchaseOrdersList(HisPurchaseOrders hisPurchaseOrders);

    /**
     * 新增采购订单
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 结果
     */
    public int insertHisPurchaseOrders(HisPurchaseOrders hisPurchaseOrders);

    /**
     * 修改采购订单
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 结果
     */
    public int updateHisPurchaseOrders(HisPurchaseOrders hisPurchaseOrders);

    /**
     * 批量删除采购订单
     * 
     * @param purIds 需要删除的采购订单主键集合
     * @return 结果
     */
    public int deleteHisPurchaseOrdersByPurIds(String purIds);

    /**
     * 删除采购订单信息
     * 
     * @param purId 采购订单主键
     * @return 结果
     */
    public int deleteHisPurchaseOrdersByPurId(Long purId);
}
