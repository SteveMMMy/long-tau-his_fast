package com.ruoyi.project.his.plans.service;

import java.util.List;
import com.ruoyi.project.his.plans.domain.HisProcurementPlans;

/**
 * 采购计划单Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface IHisProcurementPlansService 
{
    /**
     * 查询采购计划单
     * 
     * @param prcpId 采购计划单主键
     * @return 采购计划单
     */
    public HisProcurementPlans selectHisProcurementPlansByPrcpId(Long prcpId);

    /**
     * 查询采购计划单列表
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 采购计划单集合
     */
    public List<HisProcurementPlans> selectHisProcurementPlansList(HisProcurementPlans hisProcurementPlans);

    /**
     * 新增采购计划单
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 结果
     */
    public int insertHisProcurementPlans(HisProcurementPlans hisProcurementPlans);

    /**
     * 修改采购计划单
     * 
     * @param hisProcurementPlans 采购计划单
     * @return 结果
     */
    public int updateHisProcurementPlans(HisProcurementPlans hisProcurementPlans);

    /**
     * 修改采购计划单状态
     *
     * @param prcpId 采购计划单ID
     * @param prcpStatus 采购计划单状态
     * @return 结果
     */
    public int updateHisProcurementPlansStatus(Long prcpId, Long prcpStatus);

    /**
     * 批量删除采购计划单
     * 
     * @param prcpIds 需要删除的采购计划单主键集合
     * @return 结果
     */
    public int deleteHisProcurementPlansByPrcpIds(String prcpIds);

    /**
     * 删除采购计划单信息
     * 
     * @param prcpId 采购计划单主键
     * @return 结果
     */
    public int deleteHisProcurementPlansByPrcpId(Long prcpId);
}
