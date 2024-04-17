package com.ruoyi.project.test.producers.mapper;

import java.util.List;
import com.ruoyi.project.test.producers.domain.HisProducers;

/**
 * 生产商Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
public interface HisProducersMapper 
{
    /**
     * 查询生产商
     * 
     * @param pdcNumber 生产商主键
     * @return 生产商
     */
    public HisProducers selectHisProducersByPdcNumber(Long pdcNumber);

    /**
     * 查询生产商列表
     * 
     * @param hisProducers 生产商
     * @return 生产商集合
     */
    public List<HisProducers> selectHisProducersList(HisProducers hisProducers);

    /**
     * 新增生产商
     * 
     * @param hisProducers 生产商
     * @return 结果
     */
    public int insertHisProducers(HisProducers hisProducers);

    /**
     * 修改生产商
     * 
     * @param hisProducers 生产商
     * @return 结果
     */
    public int updateHisProducers(HisProducers hisProducers);

    /**
     * 删除生产商
     * 
     * @param pdcNumber 生产商主键
     * @return 结果
     */
    public int deleteHisProducersByPdcNumber(Long pdcNumber);

    /**
     * 批量删除生产商
     * 
     * @param pdcNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisProducersByPdcNumbers(String[] pdcNumbers);
}
