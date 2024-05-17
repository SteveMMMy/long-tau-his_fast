package com.ruoyi.project.his.diagnosis.service;

import java.util.List;
import com.ruoyi.project.his.diagnosis.domain.HisPatientsDiag;

/**
 * 患者病历Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public interface IHisPatientsDiagService 
{
    /**
     * 查询患者病历
     * 
     * @param patientId 患者病历主键
     * @return 患者病历
     */
    public HisPatientsDiag selectHisPatientsDiagByPatientId(Long patientId);

    /**
     * 查询患者病历列表
     * 
     * @param hisPatientsDiag 患者病历
     * @return 患者病历集合
     */
    public List<HisPatientsDiag> selectHisPatientsDiagList(HisPatientsDiag hisPatientsDiag);

    /**
     * 新增患者病历
     * 
     * @param hisPatientsDiag 患者病历
     * @return 结果
     */
    public int insertHisPatientsDiag(HisPatientsDiag hisPatientsDiag);

    /**
     * 修改患者病历
     * 
     * @param hisPatientsDiag 患者病历
     * @return 结果
     */
    public int updateHisPatientsDiag(HisPatientsDiag hisPatientsDiag);

    /**
     * 批量删除患者病历
     * 
     * @param patientIds 需要删除的患者病历主键集合
     * @return 结果
     */
    public int deleteHisPatientsDiagByPatientIds(String patientIds);

    /**
     * 删除患者病历信息
     * 
     * @param patientId 患者病历主键
     * @return 结果
     */
    public int deleteHisPatientsDiagByPatientId(Long patientId);
}
