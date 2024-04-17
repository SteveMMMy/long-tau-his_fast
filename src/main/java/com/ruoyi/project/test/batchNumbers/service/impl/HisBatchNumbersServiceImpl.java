package com.ruoyi.project.test.batchNumbers.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.test.batchNumbers.mapper.HisBatchNumbersMapper;
import com.ruoyi.project.test.batchNumbers.domain.HisBatchNumbers;
import com.ruoyi.project.test.batchNumbers.service.IHisBatchNumbersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 生产批号Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
@Service
public class HisBatchNumbersServiceImpl implements IHisBatchNumbersService 
{
    @Autowired
    private HisBatchNumbersMapper hisBatchNumbersMapper;

    /**
     * 查询生产批号
     * 
     * @param batchNumber 生产批号主键
     * @return 生产批号
     */
    @Override
    public HisBatchNumbers selectHisBatchNumbersByBatchNumber(String batchNumber)
    {
        return hisBatchNumbersMapper.selectHisBatchNumbersByBatchNumber(batchNumber);
    }

    /**
     * 查询生产批号列表
     * 
     * @param hisBatchNumbers 生产批号
     * @return 生产批号
     */
    @Override
    public List<HisBatchNumbers> selectHisBatchNumbersList(HisBatchNumbers hisBatchNumbers)
    {
        return hisBatchNumbersMapper.selectHisBatchNumbersList(hisBatchNumbers);
    }

    /**
     * 新增生产批号
     * 
     * @param hisBatchNumbers 生产批号
     * @return 结果
     */
    @Override
    public int insertHisBatchNumbers(HisBatchNumbers hisBatchNumbers)
    {
        return hisBatchNumbersMapper.insertHisBatchNumbers(hisBatchNumbers);
    }

    /**
     * 修改生产批号
     * 
     * @param hisBatchNumbers 生产批号
     * @return 结果
     */
    @Override
    public int updateHisBatchNumbers(HisBatchNumbers hisBatchNumbers)
    {
        return hisBatchNumbersMapper.updateHisBatchNumbers(hisBatchNumbers);
    }

    /**
     * 批量删除生产批号
     * 
     * @param batchNumbers 需要删除的生产批号主键
     * @return 结果
     */
    @Override
    public int deleteHisBatchNumbersByBatchNumbers(String batchNumbers)
    {
        return hisBatchNumbersMapper.deleteHisBatchNumbersByBatchNumbers(Convert.toStrArray(batchNumbers));
    }

    /**
     * 删除生产批号信息
     * 
     * @param batchNumber 生产批号主键
     * @return 结果
     */
    @Override
    public int deleteHisBatchNumbersByBatchNumber(String batchNumber)
    {
        return hisBatchNumbersMapper.deleteHisBatchNumbersByBatchNumber(batchNumber);
    }
}
