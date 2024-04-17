package com.ruoyi.project.test.patients.mapper;

import java.util.List;
import com.ruoyi.project.test.patients.domain.HisPatients;

/**
 * 患者信息Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-04-17
 */
public interface HisPatientsMapper 
{
    /**
     * 查询患者信息
     * 
     * @param patientId 患者信息主键
     * @return 患者信息
     */
    public HisPatients selectHisPatientsByPatientId(Long patientId);

    /**
     * 查询患者信息列表
     * 
     * @param hisPatients 患者信息
     * @return 患者信息集合
     */
    public List<HisPatients> selectHisPatientsList(HisPatients hisPatients);

    /**
     * 新增患者信息
     * 
     * @param hisPatients 患者信息
     * @return 结果
     */
    public int insertHisPatients(HisPatients hisPatients);

    /**
     * 修改患者信息
     * 
     * @param hisPatients 患者信息
     * @return 结果
     */
    public int updateHisPatients(HisPatients hisPatients);

    /**
     * 删除患者信息
     * 
     * @param patientId 患者信息主键
     * @return 结果
     */
    public int deleteHisPatientsByPatientId(Long patientId);

    /**
     * 批量删除患者信息
     * 
     * @param patientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPatientsByPatientIds(String[] patientIds);
}