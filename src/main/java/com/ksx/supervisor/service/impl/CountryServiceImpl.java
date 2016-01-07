package com.ksx.supervisor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ksx.base.service.impl.BaseServiceImpl;
import com.ksx.supervisor.mapper.CountryMapper;
import com.ksx.supervisor.model.Country;
import com.ksx.supervisor.model.CountryQueryModel;
import com.ksx.supervisor.service.CountryService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("countryService")
public class CountryServiceImpl extends BaseServiceImpl<Country> implements CountryService {

    @Override
    public List<Country> selectByCountry(Country country, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(country.getCountryname())) {
            criteria.andLike("countryname", "%" + country.getCountryname() + "%");
        }
        if (StringUtil.isNotEmpty(country.getCountrycode())) {
            criteria.andLike("countrycode", "%" + country.getCountrycode() + "%");
        }
        if (country.getId() != null) {
            criteria.andEqualTo("id", country.getId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    @Override
    public PageInfo<Country> selectByCountryQueryModel(CountryQueryModel queryModel) {
        return ((CountryMapper) getMapper()).selectByCountryQueryModel(queryModel);
    }
}
