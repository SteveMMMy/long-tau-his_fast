package com.ruoyi.project.his.diagnosis.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.diagnosis.domain.HisMedicalRecord;
import com.ruoyi.project.his.diagnosis.mapper.HisPatientsDiagMapper;
import com.ruoyi.project.his.diagnosis.domain.HisPatientsDiag;
import com.ruoyi.project.his.diagnosis.service.IHisPatientsDiagService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 患者病历Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Service
public class HisPatientsDiagServiceImpl implements IHisPatientsDiagService 
{
    @Autowired
    private HisPatientsDiagMapper hisPatientsDiagMapper;

    /**
     * 查询患者病历
     * 
     * @param patientId 患者病历主键
     * @return 患者病历
     */
    @Override
    public HisPatientsDiag selectHisPatientsDiagByPatientId(Long patientId)
    {
        return hisPatientsDiagMapper.selectHisPatientsDiagByPatientId(patientId);
    }

    /**
     * 查询患者病历列表
     * 
     * @param hisPatientsDiag 患者病历
     * @return 患者病历
     */
    @Override
    public List<HisPatientsDiag> selectHisPatientsDiagList(HisPatientsDiag hisPatientsDiag)
    {
        return hisPatientsDiagMapper.selectHisPatientsDiagList(hisPatientsDiag);
    }

    /**
     * 新增患者病历
     * 
     * @param hisPatientsDiag 患者病历
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisPatientsDiag(HisPatientsDiag hisPatientsDiag)
    {
        int rows = hisPatientsDiagMapper.insertHisPatientsDiag(hisPatientsDiag);
        insertHisMedicalRecord(hisPatientsDiag);
        return rows;
    }

    /**
     * 修改患者病历
     * 
     * @param hisPatientsDiag 患者病历
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisPatientsDiag(HisPatientsDiag hisPatientsDiag)
    {
        hisPatientsDiagMapper.deleteHisMedicalRecordByPatientId(hisPatientsDiag.getPatientId());
        insertHisMedicalRecord(hisPatientsDiag);
        return hisPatientsDiagMapper.updateHisPatientsDiag(hisPatientsDiag);
    }

    /**
     * 批量删除患者病历
     * 
     * @param patientIds 需要删除的患者病历主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPatientsDiagByPatientIds(String patientIds)
    {
        hisPatientsDiagMapper.deleteHisMedicalRecordByPatientIds(Convert.toStrArray(patientIds));
        return hisPatientsDiagMapper.deleteHisPatientsDiagByPatientIds(Convert.toStrArray(patientIds));
    }

    /**
     * 删除患者病历信息
     * 
     * @param patientId 患者病历主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPatientsDiagByPatientId(Long patientId)
    {
        hisPatientsDiagMapper.deleteHisMedicalRecordByPatientId(patientId);
        return hisPatientsDiagMapper.deleteHisPatientsDiagByPatientId(patientId);
    }

    /**
     * 新增病历信息
     * 
     * @param hisPatientsDiag 患者病历对象
     */
    public void insertHisMedicalRecord(HisPatientsDiag hisPatientsDiag)
    {
        List<HisMedicalRecord> hisMedicalRecordList = hisPatientsDiag.getHisMedicalRecordList();
        Long patientId = hisPatientsDiag.getPatientId();
        if (StringUtils.isNotNull(hisMedicalRecordList))
        {
            List<HisMedicalRecord> list = new ArrayList<HisMedicalRecord>();
            for (HisMedicalRecord hisMedicalRecord : hisMedicalRecordList)
            {
                hisMedicalRecord.setPatientId(patientId);
                list.add(hisMedicalRecord);
            }
            if (list.size() > 0)
            {
                hisPatientsDiagMapper.batchHisMedicalRecord(list);
            }
        }
    }
}
