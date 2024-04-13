package com.ruoyi.project.test.batchNumbers.mapper;

import java.util.List;
import com.ruoyi.project.test.batchNumbers.domain.HisBatchNumbers;

/**
 * 生产批号Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
public interface HisBatchNumbersMapper 
{
    /**
     * 查询生产批号
     * 
     * @param batchNumber 生产批号主键
     * @return 生产批号
     */
    public HisBatchNumbers selectHisBatchNumbersByBatchNumber(String batchNumber);

    /**
     * 查询生产批号列表
     * 
     * @param hisBatchNumbers 生产批号
     * @return 生产批号集合
     */
    public List<HisBatchNumbers> selectHisBatchNumbersList(HisBatchNumbers hisBatchNumbers);

    /**
     * 新增生产批号
     * 
     * @param hisBatchNumbers 生产批号
     * @return 结果
     */
    public int insertHisBatchNumbers(HisBatchNumbers hisBatchNumbers);

    /**
     * 修改生产批号
     * 
     * @param hisBatchNumbers 生产批号
     * @return 结果
     */
    public int updateHisBatchNumbers(HisBatchNumbers hisBatchNumbers);

    /**
     * 删除生产批号
     * 
     * @param batchNumber 生产批号主键
     * @return 结果
     */
    public int deleteHisBatchNumbersByBatchNumber(String batchNumber);

    /**
     * 批量删除生产批号
     * 
     * @param batchNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisBatchNumbersByBatchNumbers(String[] batchNumbers);
}
