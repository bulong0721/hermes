package com.hermes.profile.dao;

import com.hermes.core.dao.GenericEntityDao;
import com.hermes.profile.domain.GeoZone;

import java.util.List;

/**
 * Created by Chay on 2016/5/25.
 */
public interface GeoZoneDao extends GenericEntityDao<Long, GeoZone> {
    List<GeoZone> listProvince();
    List<GeoZone> listCityByProvince(Long provinceId);
    List<GeoZone> listDistrictByCity(Long cityId);
}
