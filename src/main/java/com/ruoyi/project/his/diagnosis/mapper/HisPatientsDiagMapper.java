package com.ruoyi.project.his.diagnosis.mapper;

import java.util.List;
import com.ruoyi.project.his.diagnosis.domain.HisPatientsDiag;
import com.ruoyi.project.his.diagnosis.domain.HisMedicalRecord;

/**
 * 患者病历Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public interface HisPatientsDiagMapper 
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
     * 删除患者病历
     * 
     * @param patientId 患者病历主键
     * @return 结果
     */
    public int deleteHisPatientsDiagByPatientId(Long patientId);

    /**
     * 批量删除患者病历
     * 
     * @param patientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPatientsDiagByPatientIds(String[] patientIds);

    /**
     * 批量删除病历
     * 
     * @param patientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisMedicalRecordByPatientIds(String[] patientIds);
    
    /**
     * 批量新增病历
     * 
     * @param hisMedicalRecordList 病历列表
     * @return 结果
     */
    public int batchHisMedicalRecord(List<HisMedicalRecord> hisMedicalRecordList);
    

    /**
     * 通过患者病历主键删除病历信息
     * 
     * @param patientId 患者病历ID
     * @return 结果
     */
    public int deleteHisMedicalRecordByPatientId(Long patientId);
}
