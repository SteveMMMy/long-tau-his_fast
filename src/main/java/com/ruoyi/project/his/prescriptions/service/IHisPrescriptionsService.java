package com.ruoyi.project.his.prescriptions.service;

import java.util.List;
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptions;

/**
 * 处方Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public interface IHisPrescriptionsService 
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
     * 批量删除处方
     * 
     * @param prscIds 需要删除的处方主键集合
     * @return 结果
     */
    public int deleteHisPrescriptionsByPrscIds(String prscIds);

    /**
     * 删除处方信息
     * 
     * @param prscId 处方主键
     * @return 结果
     */
    public int deleteHisPrescriptionsByPrscId(Long prscId);
}
