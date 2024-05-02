package com.ruoyi.project.his.purchase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.purchase.domain.HisOrdersSchedules;
import com.ruoyi.project.his.purchase.mapper.HisPurchaseOrdersMapper;
import com.ruoyi.project.his.purchase.domain.HisPurchaseOrders;
import com.ruoyi.project.his.purchase.service.IHisPurchaseOrdersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 采购订单Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Service
public class HisPurchaseOrdersServiceImpl implements IHisPurchaseOrdersService 
{
    @Autowired
    private HisPurchaseOrdersMapper hisPurchaseOrdersMapper;

    /**
     * 查询采购订单
     * 
     * @param purId 采购订单主键
     * @return 采购订单
     */
    @Override
    public HisPurchaseOrders selectHisPurchaseOrdersByPurId(Long purId)
    {
        return hisPurchaseOrdersMapper.selectHisPurchaseOrdersByPurId(purId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 采购订单
     */
    @Override
    public List<HisPurchaseOrders> selectHisPurchaseOrdersList(HisPurchaseOrders hisPurchaseOrders)
    {
        return hisPurchaseOrdersMapper.selectHisPurchaseOrdersList(hisPurchaseOrders);
    }

    /**
     * 新增采购订单
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisPurchaseOrders(HisPurchaseOrders hisPurchaseOrders)
    {
        int rows = hisPurchaseOrdersMapper.insertHisPurchaseOrders(hisPurchaseOrders);
        insertHisOrdersSchedules(hisPurchaseOrders);
        return rows;
    }

    /**
     * 修改采购订单
     * 
     * @param hisPurchaseOrders 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisPurchaseOrders(HisPurchaseOrders hisPurchaseOrders)
    {
        hisPurchaseOrdersMapper.deleteHisOrdersSchedulesByPurId(hisPurchaseOrders.getPurId());
        insertHisOrdersSchedules(hisPurchaseOrders);
        return hisPurchaseOrdersMapper.updateHisPurchaseOrders(hisPurchaseOrders);
    }

    /**
     * 批量删除采购订单
     * 
     * @param purIds 需要删除的采购订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPurchaseOrdersByPurIds(String purIds)
    {
        hisPurchaseOrdersMapper.deleteHisOrdersSchedulesByPurIds(Convert.toStrArray(purIds));
        return hisPurchaseOrdersMapper.deleteHisPurchaseOrdersByPurIds(Convert.toStrArray(purIds));
    }

    /**
     * 删除采购订单信息
     * 
     * @param purId 采购订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPurchaseOrdersByPurId(Long purId)
    {
        hisPurchaseOrdersMapper.deleteHisOrdersSchedulesByPurId(purId);
        return hisPurchaseOrdersMapper.deleteHisPurchaseOrdersByPurId(purId);
    }

    /**
     * 新增采购订单明细信息
     * 
     * @param hisPurchaseOrders 采购订单对象
     */
    public void insertHisOrdersSchedules(HisPurchaseOrders hisPurchaseOrders)
    {
        List<HisOrdersSchedules> hisOrdersSchedulesList = hisPurchaseOrders.getHisOrdersSchedulesList();
        Long purId = hisPurchaseOrders.getPurId();
        if (StringUtils.isNotNull(hisOrdersSchedulesList))
        {
            List<HisOrdersSchedules> list = new ArrayList<HisOrdersSchedules>();
            for (HisOrdersSchedules hisOrdersSchedules : hisOrdersSchedulesList)
            {
                hisOrdersSchedules.setPurId(purId);
                list.add(hisOrdersSchedules);
            }
            if (list.size() > 0)
            {
                hisPurchaseOrdersMapper.batchHisOrdersSchedules(list);
            }
        }
    }
}
