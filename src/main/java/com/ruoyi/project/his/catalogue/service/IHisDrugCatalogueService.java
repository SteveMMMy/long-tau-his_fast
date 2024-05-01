package com.ruoyi.project.his.catalogue.service;

import java.util.List;
import com.ruoyi.project.his.catalogue.domain.HisDrugCatalogue;

/**
 * 药品目录Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface IHisDrugCatalogueService 
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
     * 批量删除药品目录
     * 
     * @param catIds 需要删除的药品目录主键集合
     * @return 结果
     */
    public int deleteHisDrugCatalogueByCatIds(String catIds);

    /**
     * 删除药品目录信息
     * 
     * @param catId 药品目录主键
     * @return 结果
     */
    public int deleteHisDrugCatalogueByCatId(Long catId);
}
