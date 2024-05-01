package com.ruoyi.project.his.procurement_plans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.procurement_plans.domain.HisProcurementSchedules;
import com.ruoyi.project.his.procurement_plans.mapper.HisProcurementPlansMapper;
import com.ruoyi.project.his.procurement_plans.domain.HisProcurementPlans;
import com.ruoyi.project.his.procurement_plans.service.IHisProcurementPlansService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 采购计划单Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Service
public class HisProcurementPlansServiceImpl implements IHisProcurementPlansService 
{
    @Autowired
    private HisProcurementPlansMapper hisProcurementPlansMapper;

    /**
     * 查询采购计划单
     * 
     * @param prcpId 采购计划单主键
     * @return 采购计划单
     */
    @Override
    public HisProcurementPlans selectHisProcurementPlansByPrcpId(Long prcpId)
    {
        return hisProcurementPlansMapper.selectHisProcurementPlansByPrcpId(prcpId);
    }

    /**
     * 查询采购计划单列表
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 采购计划单
     */
    @Override
    public List<HisProcurementPlans> selectHisProcurementPlansList(HisProcurementPlans hisProcurementPlans)
    {
        return hisProcurementPlansMapper.selectHisProcurementPlansList(hisProcurementPlans);
    }

    /**
     * 新增采购计划单
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisProcurementPlans(HisProcurementPlans hisProcurementPlans)
    {
        int rows = hisProcurementPlansMapper.insertHisProcurementPlans(hisProcurementPlans);
        insertHisProcurementSchedules(hisProcurementPlans);
        return rows;
    }

    /**
     * 修改采购计划单
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisProcurementPlans(HisProcurementPlans hisProcurementPlans)
    {
        hisProcurementPlansMapper.deleteHisProcurementSchedulesByPrcpId(hisProcurementPlans.getPrcpId());
        insertHisProcurementSchedules(hisProcurementPlans);
        return hisProcurementPlansMapper.updateHisProcurementPlans(hisProcurementPlans);
    }

    /**
     * 批量删除采购计划单
     * 
     * @param prcpIds 需要删除的采购计划单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisProcurementPlansByPrcpIds(String prcpIds)
    {
        hisProcurementPlansMapper.deleteHisProcurementSchedulesByPrcpIds(Convert.toStrArray(prcpIds));
        return hisProcurementPlansMapper.deleteHisProcurementPlansByPrcpIds(Convert.toStrArray(prcpIds));
    }

    /**
     * 删除采购计划单信息
     * 
     * @param prcpId 采购计划单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisProcurementPlansByPrcpId(Long prcpId)
    {
        hisProcurementPlansMapper.deleteHisProcurementSchedulesByPrcpId(prcpId);
        return hisProcurementPlansMapper.deleteHisProcurementPlansByPrcpId(prcpId);
    }

    /**
     * 新增采购计划明细信息
     * 
     * @param hisProcurementPlans 采购计划单对象
     */
    public void insertHisProcurementSchedules(HisProcurementPlans hisProcurementPlans)
    {
        List<HisProcurementSchedules> hisProcurementSchedulesList = hisProcurementPlans.getHisProcurementSchedulesList();
        Long prcpId = hisProcurementPlans.getPrcpId();
        if (StringUtils.isNotNull(hisProcurementSchedulesList))
        {
            List<HisProcurementSchedules> list = new ArrayList<HisProcurementSchedules>();
            for (HisProcurementSchedules hisProcurementSchedules : hisProcurementSchedulesList)
            {
                hisProcurementSchedules.setPrcpId(prcpId);
                list.add(hisProcurementSchedules);
            }
            if (list.size() > 0)
            {
                hisProcurementPlansMapper.batchHisProcurementSchedules(list);
            }
        }
    }
}
