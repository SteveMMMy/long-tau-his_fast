package com.ruoyi.project.his.entry.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.entry.domain.HisEntrySchedules;
import com.ruoyi.project.his.entry.mapper.HisWarehousingEntryMapper;
import com.ruoyi.project.his.entry.domain.HisWarehousingEntry;
import com.ruoyi.project.his.entry.service.IHisWarehousingEntryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 入库单Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
@Service
public class HisWarehousingEntryServiceImpl implements IHisWarehousingEntryService 
{
    @Autowired
    private HisWarehousingEntryMapper hisWarehousingEntryMapper;

    /**
     * 查询入库单
     * 
     * @param entId 入库单主键
     * @return 入库单
     */
    @Override
    public HisWarehousingEntry selectHisWarehousingEntryByEntId(Long entId)
    {
        return hisWarehousingEntryMapper.selectHisWarehousingEntryByEntId(entId);
    }

    /**
     * 查询入库单列表
     * 
     * @param hisWarehousingEntry 入库单
     * @return 入库单
     */
    @Override
    public List<HisWarehousingEntry> selectHisWarehousingEntryList(HisWarehousingEntry hisWarehousingEntry)
    {
        return hisWarehousingEntryMapper.selectHisWarehousingEntryList(hisWarehousingEntry);
    }

    /**
     * 新增入库单
     * 
     * @param hisWarehousingEntry 入库单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisWarehousingEntry(HisWarehousingEntry hisWarehousingEntry)
    {
        int rows = hisWarehousingEntryMapper.insertHisWarehousingEntry(hisWarehousingEntry);
        insertHisEntrySchedules(hisWarehousingEntry);
        return rows;
    }

    /**
     * 修改入库单
     * 
     * @param hisWarehousingEntry 入库单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisWarehousingEntry(HisWarehousingEntry hisWarehousingEntry)
    {
        hisWarehousingEntryMapper.deleteHisEntrySchedulesByEntId(hisWarehousingEntry.getEntId());
        insertHisEntrySchedules(hisWarehousingEntry);
        return hisWarehousingEntryMapper.updateHisWarehousingEntry(hisWarehousingEntry);
    }

    /**
     * 批量删除入库单
     * 
     * @param entIds 需要删除的入库单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisWarehousingEntryByEntIds(String entIds)
    {
        hisWarehousingEntryMapper.deleteHisEntrySchedulesByEntIds(Convert.toStrArray(entIds));
        return hisWarehousingEntryMapper.deleteHisWarehousingEntryByEntIds(Convert.toStrArray(entIds));
    }

    /**
     * 删除入库单信息
     * 
     * @param entId 入库单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisWarehousingEntryByEntId(Long entId)
    {
        hisWarehousingEntryMapper.deleteHisEntrySchedulesByEntId(entId);
        return hisWarehousingEntryMapper.deleteHisWarehousingEntryByEntId(entId);
    }

    /**
     * 新增入库单明细信息
     * 
     * @param hisWarehousingEntry 入库单对象
     */
    public void insertHisEntrySchedules(HisWarehousingEntry hisWarehousingEntry)
    {
        List<HisEntrySchedules> hisEntrySchedulesList = hisWarehousingEntry.getHisEntrySchedulesList();
        Long entId = hisWarehousingEntry.getEntId();
        if (StringUtils.isNotNull(hisEntrySchedulesList))
        {
            List<HisEntrySchedules> list = new ArrayList<HisEntrySchedules>();
            for (HisEntrySchedules hisEntrySchedules : hisEntrySchedulesList)
            {
                hisEntrySchedules.setEntId(entId);
                list.add(hisEntrySchedules);
            }
            if (list.size() > 0)
            {
                hisWarehousingEntryMapper.batchHisEntrySchedules(list);
            }
        }
    }
}
