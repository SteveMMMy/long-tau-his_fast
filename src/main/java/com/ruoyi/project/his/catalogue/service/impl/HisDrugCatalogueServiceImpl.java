package com.ruoyi.project.his.catalogue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.his.catalogue.domain.HisInventory;
import com.ruoyi.project.his.catalogue.mapper.HisDrugCatalogueMapper;
import com.ruoyi.project.his.catalogue.domain.HisDrugCatalogue;
import com.ruoyi.project.his.catalogue.service.IHisDrugCatalogueService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 药品目录Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Service
public class HisDrugCatalogueServiceImpl implements IHisDrugCatalogueService 
{
    @Autowired
    private HisDrugCatalogueMapper hisDrugCatalogueMapper;

    /**
     * 查询药品目录
     * 
     * @param catId 药品目录主键
     * @return 药品目录
     */
    @Override
    public HisDrugCatalogue selectHisDrugCatalogueByCatId(Long catId)
    {
        return hisDrugCatalogueMapper.selectHisDrugCatalogueByCatId(catId);
    }

    /**
     * 查询药品目录列表
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 药品目录
     */
    @Override
    public List<HisDrugCatalogue> selectHisDrugCatalogueList(HisDrugCatalogue hisDrugCatalogue)
    {
        return hisDrugCatalogueMapper.selectHisDrugCatalogueList(hisDrugCatalogue);
    }

    /**
     * 新增药品目录
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHisDrugCatalogue(HisDrugCatalogue hisDrugCatalogue)
    {
        int rows = hisDrugCatalogueMapper.insertHisDrugCatalogue(hisDrugCatalogue);
        insertHisInventory(hisDrugCatalogue);
        return rows;
    }

    /**
     * 修改药品目录
     * 
     * @param hisDrugCatalogue 药品目录
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHisDrugCatalogue(HisDrugCatalogue hisDrugCatalogue)
    {
        hisDrugCatalogueMapper.deleteHisInventoryByCatId(hisDrugCatalogue.getCatId());
        insertHisInventory(hisDrugCatalogue);
        return hisDrugCatalogueMapper.updateHisDrugCatalogue(hisDrugCatalogue);
    }

    /**
     * 批量删除药品目录
     * 
     * @param catIds 需要删除的药品目录主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisDrugCatalogueByCatIds(String catIds)
    {
        hisDrugCatalogueMapper.deleteHisInventoryByCatIds(Convert.toStrArray(catIds));
        return hisDrugCatalogueMapper.deleteHisDrugCatalogueByCatIds(Convert.toStrArray(catIds));
    }

    /**
     * 删除药品目录信息
     * 
     * @param catId 药品目录主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHisDrugCatalogueByCatId(Long catId)
    {
        hisDrugCatalogueMapper.deleteHisInventoryByCatId(catId);
        return hisDrugCatalogueMapper.deleteHisDrugCatalogueByCatId(catId);
    }

    /**
     * 新增库存信息信息
     * 
     * @param hisDrugCatalogue 药品目录对象
     */
    public void insertHisInventory(HisDrugCatalogue hisDrugCatalogue)
    {
        List<HisInventory> hisInventoryList = hisDrugCatalogue.getHisInventoryList();
        Long catId = hisDrugCatalogue.getCatId();
        if (StringUtils.isNotNull(hisInventoryList))
        {
            List<HisInventory> list = new ArrayList<HisInventory>();
            for (HisInventory hisInventory : hisInventoryList)
            {
                hisInventory.setCatId(catId);
                list.add(hisInventory);
            }
            if (list.size() > 0)
            {
                hisDrugCatalogueMapper.batchHisInventory(list);
            }
        }
    }
}
