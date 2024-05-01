package com.ruoyi.project.his.suppliers.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.his.suppliers.mapper.HisSuppliersMapper;
import com.ruoyi.project.his.suppliers.domain.HisSuppliers;
import com.ruoyi.project.his.suppliers.service.IHisSuppliersService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 供应商Service业务层处理
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Service
public class HisSuppliersServiceImpl implements IHisSuppliersService 
{
    @Autowired
    private HisSuppliersMapper hisSuppliersMapper;

    /**
     * 查询供应商
     * 
     * @param splId 供应商主键
     * @return 供应商
     */
    @Override
    public HisSuppliers selectHisSuppliersBySplId(Long splId)
    {
        return hisSuppliersMapper.selectHisSuppliersBySplId(splId);
    }

    /**
     * 查询供应商列表
     * 
     * @param hisSuppliers 供应商
     * @return 供应商
     */
    @Override
    public List<HisSuppliers> selectHisSuppliersList(HisSuppliers hisSuppliers)
    {
        return hisSuppliersMapper.selectHisSuppliersList(hisSuppliers);
    }

    /**
     * 新增供应商
     * 
     * @param hisSuppliers 供应商
     * @return 结果
     */
    @Override
    public int insertHisSuppliers(HisSuppliers hisSuppliers)
    {
        return hisSuppliersMapper.insertHisSuppliers(hisSuppliers);
    }

    /**
     * 修改供应商
     * 
     * @param hisSuppliers 供应商
     * @return 结果
     */
    @Override
    public int updateHisSuppliers(HisSuppliers hisSuppliers)
    {
        return hisSuppliersMapper.updateHisSuppliers(hisSuppliers);
    }

    /**
     * 批量删除供应商
     * 
     * @param splIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteHisSuppliersBySplIds(String splIds)
    {
        return hisSuppliersMapper.deleteHisSuppliersBySplIds(Convert.toStrArray(splIds));
    }

    /**
     * 删除供应商信息
     * 
     * @param splId 供应商主键
     * @return 结果
     */
    @Override
    public int deleteHisSuppliersBySplId(Long splId)
    {
        return hisSuppliersMapper.deleteHisSuppliersBySplId(splId);
    }
}
