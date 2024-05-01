package com.ruoyi.project.his.suppliers.service;

import java.util.List;
import com.ruoyi.project.his.suppliers.domain.HisSuppliers;

/**
 * 供应商Service接口
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public interface IHisSuppliersService 
{
    /**
     * 查询供应商
     * 
     * @param splId 供应商主键
     * @return 供应商
     */
    public HisSuppliers selectHisSuppliersBySplId(Long splId);

    /**
     * 查询供应商列表
     * 
     * @param hisSuppliers 供应商
     * @return 供应商集合
     */
    public List<HisSuppliers> selectHisSuppliersList(HisSuppliers hisSuppliers);

    /**
     * 新增供应商
     * 
     * @param hisSuppliers 供应商
     * @return 结果
     */
    public int insertHisSuppliers(HisSuppliers hisSuppliers);

    /**
     * 修改供应商
     * 
     * @param hisSuppliers 供应商
     * @return 结果
     */
    public int updateHisSuppliers(HisSuppliers hisSuppliers);

    /**
     * 批量删除供应商
     * 
     * @param splIds 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteHisSuppliersBySplIds(String splIds);

    /**
     * 删除供应商信息
     * 
     * @param splId 供应商主键
     * @return 结果
     */
    public int deleteHisSuppliersBySplId(Long splId);
}
