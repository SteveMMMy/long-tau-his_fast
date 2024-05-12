package com.ruoyi.project.his.plans.mapper;

import java.util.List;
import com.ruoyi.project.his.plans.domain.HisProcurementPlans;
import com.ruoyi.project.his.plans.domain.HisProcurementSchedules;

/**
 * 采购计划单Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface HisProcurementPlansMapper 
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
     * 删除采购计划单
     * 
     * @param prcpId 采购计划单主键
     * @return 结果
     */
    public int deleteHisProcurementPlansByPrcpId(Long prcpId);

    /**
     * 批量删除采购计划单
     * 
     * @param prcpIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisProcurementPlansByPrcpIds(String[] prcpIds);

    /**
     * 批量删除采购计划明细
     * 
     * @param prcpIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisProcurementSchedulesByPrcpIds(String[] prcpIds);
    
    /**
     * 批量新增采购计划明细
     * 
     * @param hisProcurementSchedulesList 采购计划明细列表
     * @return 结果
     */
    public int batchHisProcurementSchedules(List<HisProcurementSchedules> hisProcurementSchedulesList);
    

    /**
     * 通过采购计划单主键删除采购计划明细信息
     * 
     * @param prcpId 采购计划单ID
     * @return 结果
     */
    public int deleteHisProcurementSchedulesByPrcpId(Long prcpId);
}
