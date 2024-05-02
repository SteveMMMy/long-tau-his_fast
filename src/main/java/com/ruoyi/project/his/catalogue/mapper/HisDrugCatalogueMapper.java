package com.ruoyi.project.his.catalogue.mapper;

import java.util.List;
import com.ruoyi.project.his.catalogue.domain.HisDrugCatalogue;
import com.ruoyi.project.his.catalogue.domain.HisInventory;

/**
 * 药品目录Mapper接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface HisDrugCatalogueMapper 
{
    /**
     * 查询药品目录
     * 
     * @param catId 药品目录主键
     * @return 药品目录
     */
    public HisDrugCatalogue selectHisDrugCatalogueByCatId(Long catId);

    /**
     * 查询药品目录列表
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 药品目录集合
     */
    public List<HisDrugCatalogue> selectHisDrugCatalogueList(HisDrugCatalogue hisDrugCatalogue);

    /**
     * 新增药品目录
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 结果
     */
    public int insertHisDrugCatalogue(HisDrugCatalogue hisDrugCatalogue);

    /**
     * 修改药品目录
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 结果
     */
    public int updateHisDrugCatalogue(HisDrugCatalogue hisDrugCatalogue);

    /**
     * 删除药品目录
     * 
     * @param catId 药品目录主键
     * @return 结果
     */
    public int deleteHisDrugCatalogueByCatId(Long catId);

    /**
     * 批量删除药品目录
     * 
     * @param catIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisDrugCatalogueByCatIds(String[] catIds);

    /**
     * 批量删除库存信息
     * 
     * @param catIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisInventoryByCatIds(String[] catIds);
    
    /**
     * 批量新增库存信息
     * 
     * @param hisInventoryList 库存信息列表
     * @return 结果
     */
    public int batchHisInventory(List<HisInventory> hisInventoryList);
    

    /**
     * 通过药品目录主键删除库存信息信息
     * 
     * @param catId 药品目录ID
     * @return 结果
     */
    public int deleteHisInventoryByCatId(Long catId);
}
