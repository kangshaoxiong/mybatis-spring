package com.ksx.supervisor.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ksx.base.service.BaseService;
import com.ksx.supervisor.model.Country;
import com.ksx.supervisor.model.CountryQueryModel;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface CountryService extends BaseService<Country> {

    /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Country> selectByCountry(Country country, int page, int rows);

    /**
     * 分页查询,分页插件4.0.3版本特性演示
     *
     * @param queryModel
     * @return
     */
    PageInfo<Country> selectByCountryQueryModel(CountryQueryModel queryModel);

}
