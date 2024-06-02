package com.ruoyi.project.his.prescriptions.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptionsSchedules;
import com.ruoyi.project.his.prescriptions.mapper.HisPrescriptionsMapper;
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptions;
import com.ruoyi.project.his.prescriptions.service.IHisPrescriptionsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 处方Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Service
public class HisPrescriptionsServiceImpl implements IHisPrescriptionsService 
{
    @Autowired
    private HisPrescriptionsMapper hisPrescriptionsMapper;

    /**
     * 查询处方
     * 
     * @param prscId 处方主键
     * @return 处方
     */
    @Override
    public HisPrescriptions selectHisPrescriptionsByPrscId(Long prscId)
    {
        return hisPrescriptionsMapper.selectHisPrescriptionsByPrscId(prscId);
    }

    /**
     * 查询处方列表
     * 
     * @param hisPrescriptions 处方
     * @return 处方
     */
    @Override
    public List<HisPrescriptions> selectHisPrescriptionsList(HisPrescriptions hisPrescriptions)
    {
        return hisPrescriptionsMapper.selectHisPrescriptionsList(hisPrescriptions);
    }

    /**
     * 查询某处方明细
     *
     * @param prscId 处方ID
     * @return 处方明细集合
     */
    @Override
    public List<HisPrescriptionsSchedules> selectHisPrescriptionsSchedulesList(Long prscId) {
        HisPrescriptions hisPrescriptions = hisPrescriptionsMapper.selectHisPrescriptionsByPrscId(prscId);
        return hisPrescriptions.getHisPrescriptionsSchedulesList();
    }

    /**
     * 新增处方
     * 
     * @param hisPrescriptions 处方
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisPrescriptions(HisPrescriptions hisPrescriptions)
    {
        int rows = hisPrescriptionsMapper.insertHisPrescriptions(hisPrescriptions);
        insertHisPrescriptionsSchedules(hisPrescriptions);
        return rows;
    }

    /**
     * 修改处方
     * 
     * @param hisPrescriptions 处方
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisPrescriptions(HisPrescriptions hisPrescriptions)
    {
        hisPrescriptionsMapper.deleteHisPrescriptionsSchedulesByPrscId(hisPrescriptions.getPrscId());
        insertHisPrescriptionsSchedules(hisPrescriptions);
        return hisPrescriptionsMapper.updateHisPrescriptions(hisPrescriptions);
    }

    /**
     * 修改处方表头信息
     *
     * @param hisPrescriptions 处方
     * @return 结果
     */
    @Override
    public int updateHisPrescriptionsInfo(HisPrescriptions hisPrescriptions) {
        return hisPrescriptionsMapper.updateHisPrescriptions(hisPrescriptions);
    }

    /**
     * 修改处方明细
     *
     * @param hisPrescriptions 处方
     * @return 结果
     */
    @Override
    public int updateHisPrescriptionsSchedulesList(HisPrescriptions hisPrescriptions) {
        int rows = 0;

        List<HisPrescriptionsSchedules> hisPrescriptionsSchedulesList = hisPrescriptions.getHisPrescriptionsSchedulesList();
        for (HisPrescriptionsSchedules hisPrescriptionsSchedules : hisPrescriptionsSchedulesList) {
            rows += hisPrescriptionsMapper.updateHisPrescriptionsSchedules(hisPrescriptionsSchedules);
        }

        return rows;
    }

    /**
     * 批量删除处方
     * 
     * @param prscIds 需要删除的处方主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPrescriptionsByPrscIds(String prscIds)
    {
        hisPrescriptionsMapper.deleteHisPrescriptionsSchedulesByPrscIds(Convert.toStrArray(prscIds));
        return hisPrescriptionsMapper.deleteHisPrescriptionsByPrscIds(Convert.toStrArray(prscIds));
    }

    /**
     * 删除处方信息
     * 
     * @param prscId 处方主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisPrescriptionsByPrscId(Long prscId)
    {
        hisPrescriptionsMapper.deleteHisPrescriptionsSchedulesByPrscId(prscId);
        return hisPrescriptionsMapper.deleteHisPrescriptionsByPrscId(prscId);
    }

    /**
     * 新增处方明细信息
     * 
     * @param hisPrescriptions 处方对象
     */
    public void insertHisPrescriptionsSchedules(HisPrescriptions hisPrescriptions)
    {
        List<HisPrescriptionsSchedules> hisPrescriptionsSchedulesList = hisPrescriptions.getHisPrescriptionsSchedulesList();
        Long prscId = hisPrescriptions.getPrscId();
        if (StringUtils.isNotNull(hisPrescriptionsSchedulesList))
        {
            List<HisPrescriptionsSchedules> list = new ArrayList<HisPrescriptionsSchedules>();
            for (HisPrescriptionsSchedules hisPrescriptionsSchedules : hisPrescriptionsSchedulesList)
            {
                hisPrescriptionsSchedules.setPrscId(prscId);
                list.add(hisPrescriptionsSchedules);
            }
            if (list.size() > 0)
            {
                hisPrescriptionsMapper.batchHisPrescriptionsSchedules(list);
            }
        }
    }
}
