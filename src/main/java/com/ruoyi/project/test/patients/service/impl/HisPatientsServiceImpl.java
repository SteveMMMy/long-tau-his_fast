package com.ruoyi.project.test.patients.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.test.patients.mapper.HisPatientsMapper;
import com.ruoyi.project.test.patients.domain.HisPatients;
import com.ruoyi.project.test.patients.service.IHisPatientsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 患者信息Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-04-17
 */
@Service
public class HisPatientsServiceImpl implements IHisPatientsService 
{
    @Autowired
    private HisPatientsMapper hisPatientsMapper;

    /**
     * 查询患者信息
     * 
     * @param patientId 患者信息主键
     * @return 患者信息
     */
    @Override
    public HisPatients selectHisPatientsByPatientId(Long patientId)
    {
        return hisPatientsMapper.selectHisPatientsByPatientId(patientId);
    }

    /**
     * 查询患者信息列表
     * 
     * @param hisPatients 患者信息
     * @return 患者信息
     */
    @Override
    public List<HisPatients> selectHisPatientsList(HisPatients hisPatients)
    {
        return hisPatientsMapper.selectHisPatientsList(hisPatients);
    }

    /**
     * 新增患者信息
     * 
     * @param hisPatients 患者信息
     * @return 结果
     */
    @Override
    public int insertHisPatients(HisPatients hisPatients)
    {
        return hisPatientsMapper.insertHisPatients(hisPatients);
    }

    /**
     * 修改患者信息
     * 
     * @param hisPatients 患者信息
     * @return 结果
     */
    @Override
    public int updateHisPatients(HisPatients hisPatients)
    {
        return hisPatientsMapper.updateHisPatients(hisPatients);
    }

    /**
     * 批量删除患者信息
     * 
     * @param patientIds 需要删除的患者信息主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientsByPatientIds(String patientIds)
    {
        return hisPatientsMapper.deleteHisPatientsByPatientIds(Convert.toStrArray(patientIds));
    }

    /**
     * 删除患者信息信息
     * 
     * @param patientId 患者信息主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientsByPatientId(Long patientId)
    {
        return hisPatientsMapper.deleteHisPatientsByPatientId(patientId);
    }
}
