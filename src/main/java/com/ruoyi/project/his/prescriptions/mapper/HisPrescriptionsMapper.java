package com.ruoyi.project.his.prescriptions.mapper;

import java.util.List;
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptions;
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptionsSchedules;

/**
 * 处方Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public interface HisPrescriptionsMapper 
{
    /**
     * 查询处方
     * 
     * @param prscId 处方主键
     * @return 处方
     */
    public HisPrescriptions selectHisPrescriptionsByPrscId(Long prscId);

    /**
     * 查询处方列表
     * 
     * @param hisPrescriptions 处方
     * @return 处方集合
     */
    public List<HisPrescriptions> selectHisPrescriptionsList(HisPrescriptions hisPrescriptions);

    /**
     * 新增处方
     * 
     * @param hisPrescriptions 处方
     * @return 结果
     */
    public int insertHisPrescriptions(HisPrescriptions hisPrescriptions);

    /**
     * 修改处方
     * 
     * @param hisPrescriptions 处方
     * @return 结果
     */
    public int updateHisPrescriptions(HisPrescriptions hisPrescriptions);

    /**
     * 删除处方
     * 
     * @param prscId 处方主键
     * @return 结果
     */
    public int deleteHisPrescriptionsByPrscId(Long prscId);

    /**
     * 批量删除处方
     * 
     * @param prscIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPrescriptionsByPrscIds(String[] prscIds);

    /**
     * 修改处方明细
     * @param hisPrescriptionsSchedules 处方明细
     * @return 结果
     */
    public int updateHisPrescriptionsSchedules(HisPrescriptionsSchedules hisPrescriptionsSchedules);

    /**
     * 批量删除处方明细
     * 
     * @param prscIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPrescriptionsSchedulesByPrscIds(String[] prscIds);
    
    /**
     * 批量新增处方明细
     * 
     * @param hisPrescriptionsSchedulesList 处方明细列表
     * @return 结果
     */
    public int batchHisPrescriptionsSchedules(List<HisPrescriptionsSchedules> hisPrescriptionsSchedulesList);
    

    /**
     * 通过处方主键删除处方明细信息
     * 
     * @param prscId 处方ID
     * @return 结果
     */
    public int deleteHisPrescriptionsSchedulesByPrscId(Long prscId);
}
