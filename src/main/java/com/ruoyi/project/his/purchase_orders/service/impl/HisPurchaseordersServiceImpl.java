package com.ruoyi.project.his.purchase_orders.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.purchase_orders.domain.HisOrdersSchedules;
import com.ruoyi.project.his.purchase_orders.mapper.HisPurchaseordersMapper;
import com.ruoyi.project.his.purchase_orders.domain.HisPurchaseorders;
import com.ruoyi.project.his.purchase_orders.service.IHisPurchaseordersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 采购订单Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Service
public class HisPurchaseordersServiceImpl implements IHisPurchaseordersService 
{
    @Autowired
    private HisPurchaseordersMapper hisPurchaseordersMapper;

    /**
     * 查询采购订单
     * 
     * @param purId 采购订单主键
     * @return 采购订单
     */
    @Override
    public HisPurchaseorders selectHisPurchaseordersByPurId(Long purId)
    {
        return hisPurchaseordersMapper.selectHisPurchaseordersByPurId(purId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param hisPurchaseorders 采购订单
     * @return 采购订单
     */
    @Override
    public List<HisPurchaseorders> selectHisPurchaseordersList(HisPurchaseorders hisPurchaseorders)
    {
        return hisPurchaseordersMapper.selectHisPurchaseordersList(hisPurchaseorders);
    }

    /**
     * 新增采购订单
     * 
     * @param hisPurchaseorders 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisPurchaseorders(HisPurchaseorders hisPurchaseorders)
    {
        int rows = hisPurchaseordersMapper.insertHisPurchaseorders(hisPurchaseorders);
        insertHisOrdersSchedules(hisPurchaseorders);
        return rows;
    }

    /**
     * 修改采购订单
     * 
     * @param hisPurchaseorders 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisPurchaseorders(HisPurchaseorders hisPurchaseorders)
    {
        hisPurchaseordersMapper.deleteHisOrdersSchedulesByPurId(hisPurchaseorders.getPurId());
        insertHisOrdersSchedules(hisPurchaseorders);
        return hisPurchaseordersMapper.updateHisPurchaseorders(hisPurchaseorders);
    }

    /**
     * 批量删除采购订单
     * 
     * @param purIds 需要删除的采购订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPurchaseordersByPurIds(String purIds)
    {
        hisPurchaseordersMapper.deleteHisOrdersSchedulesByPurIds(Convert.toStrArray(purIds));
        return hisPurchaseordersMapper.deleteHisPurchaseordersByPurIds(Convert.toStrArray(purIds));
    }

    /**
     * 删除采购订单信息
     * 
     * @param purId 采购订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPurchaseordersByPurId(Long purId)
    {
        hisPurchaseordersMapper.deleteHisOrdersSchedulesByPurId(purId);
        return hisPurchaseordersMapper.deleteHisPurchaseordersByPurId(purId);
    }

    /**
     * 新增采购订单明细信息
     * 
     * @param hisPurchaseorders 采购订单对象
     */
    public void insertHisOrdersSchedules(HisPurchaseorders hisPurchaseorders)
    {
        List<HisOrdersSchedules> hisOrdersSchedulesList = hisPurchaseorders.getHisOrdersSchedulesList();
        Long purId = hisPurchaseorders.getPurId();
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
                hisPurchaseordersMapper.batchHisOrdersSchedules(list);
            }
        }
    }
}
