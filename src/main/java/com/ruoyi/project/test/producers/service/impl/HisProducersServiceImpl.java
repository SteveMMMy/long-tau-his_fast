package com.ruoyi.project.test.producers.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.test.producers.mapper.HisProducersMapper;
import com.ruoyi.project.test.producers.domain.HisProducers;
import com.ruoyi.project.test.producers.service.IHisProducersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 生产商Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
@Service
public class HisProducersServiceImpl implements IHisProducersService 
{
    @Autowired
    private HisProducersMapper hisProducersMapper;

    /**
     * 查询生产商
     * 
     * @param pdcNumber 生产商主键
     * @return 生产商
     */
    @Override
    public HisProducers selectHisProducersByPdcNumber(Long pdcNumber)
    {
        return hisProducersMapper.selectHisProducersByPdcNumber(pdcNumber);
    }

    /**
     * 查询生产商列表
     * 
     * @param hisProducers 生产商
     * @return 生产商
     */
    @Override
    public List<HisProducers> selectHisProducersList(HisProducers hisProducers)
    {
        return hisProducersMapper.selectHisProducersList(hisProducers);
    }

    /**
     * 新增生产商
     * 
     * @param hisProducers 生产商
     * @return 结果
     */
    @Override
    public int insertHisProducers(HisProducers hisProducers)
    {
        return hisProducersMapper.insertHisProducers(hisProducers);
    }

    /**
     * 修改生产商
     * 
     * @param hisProducers 生产商
     * @return 结果
     */
    @Override
    public int updateHisProducers(HisProducers hisProducers)
    {
        return hisProducersMapper.updateHisProducers(hisProducers);
    }

    /**
     * 批量删除生产商
     * 
     * @param pdcNumbers 需要删除的生产商主键
     * @return 结果
     */
    @Override
    public int deleteHisProducersByPdcNumbers(String pdcNumbers)
    {
        return hisProducersMapper.deleteHisProducersByPdcNumbers(Convert.toStrArray(pdcNumbers));
    }

    /**
     * 删除生产商信息
     * 
     * @param pdcNumber 生产商主键
     * @return 结果
     */
    @Override
    public int deleteHisProducersByPdcNumber(Long pdcNumber)
    {
        return hisProducersMapper.deleteHisProducersByPdcNumber(pdcNumber);
    }
}
