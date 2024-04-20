package com.ruoyi.project.test.registration.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.test.registration.domain.HisRegisters;
import com.ruoyi.project.test.registration.mapper.HisPatientsMapper;
import com.ruoyi.project.test.registration.domain.HisPatients;
import com.ruoyi.project.test.registration.service.IHisPatientsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 患者信息Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-04-20
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
    @Transactional
    @Override
    public int insertHisPatients(HisPatients hisPatients)
    {
        int rows = hisPatientsMapper.insertHisPatients(hisPatients);
        insertHisRegisters(hisPatients);
        return rows;
    }

    /**
     * 修改患者信息
     * 
     * @param hisPatients 患者信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisPatients(HisPatients hisPatients)
    {
        hisPatientsMapper.deleteHisRegistersByPatientId(hisPatients.getPatientId());
        insertHisRegisters(hisPatients);
        return hisPatientsMapper.updateHisPatients(hisPatients);
    }

    /**
     * 批量删除患者信息
     * 
     * @param patientIds 需要删除的患者信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPatientsByPatientIds(String patientIds)
    {
        hisPatientsMapper.deleteHisRegistersByPatientIds(Convert.toStrArray(patientIds));
        return hisPatientsMapper.deleteHisPatientsByPatientIds(Convert.toStrArray(patientIds));
    }

    /**
     * 删除患者信息信息
     * 
     * @param patientId 患者信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPatientsByPatientId(Long patientId)
    {
        hisPatientsMapper.deleteHisRegistersByPatientId(patientId);
        return hisPatientsMapper.deleteHisPatientsByPatientId(patientId);
    }

    /**
     * 新增挂号记录信息
     * 
     * @param hisPatients 患者信息对象
     */
    public void insertHisRegisters(HisPatients hisPatients)
    {
        List<HisRegisters> hisRegistersList = hisPatients.getHisRegistersList();
        Long patientId = hisPatients.getPatientId();
        if (StringUtils.isNotNull(hisRegistersList))
        {
            List<HisRegisters> list = new ArrayList<HisRegisters>();
            for (HisRegisters hisRegisters : hisRegistersList)
            {
                hisRegisters.setPatientId(patientId);
                list.add(hisRegisters);
            }
            if (list.size() > 0)
            {
                hisPatientsMapper.batchHisRegisters(list);
            }
        }
    }
}
