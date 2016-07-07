package com.hermes.profile.service;

import com.hermes.core.service.GenericEntityService;
import com.hermes.profile.domain.GeoZone;

import java.util.List;

/**
 * Created by Chay on 2016/6/3.
 */
public interface GeoZoneService  extends GenericEntityService<Long, GeoZone> {
    List<GeoZone> listProvince();
    List<GeoZone> listCityByProvince(Long provinceId);
    List<GeoZone> listDistrictByCity(Long cityId);

}
