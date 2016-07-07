package com.hermes.profile.service.impl;

import com.hermes.profile.dao.GeoZoneDao;
import com.hermes.profile.service.GeoZoneService;
import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.profile.domain.GeoZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chay on 2016/5/25.
 */
@Service
public class GeoZoneServiceImpl extends GenericEntityServiceImpl<Long, GeoZone> implements GeoZoneService {

    protected GeoZoneDao geoZoneDao;

    @Autowired
    public GeoZoneServiceImpl(GeoZoneDao geoZoneDao) {
        super(geoZoneDao);
        this.geoZoneDao = geoZoneDao;
    }

    public List<GeoZone> listProvince(){
        return geoZoneDao.listProvince();
    }

    public List<GeoZone> listCityByProvince(Long provinceId){
        return geoZoneDao.listCityByProvince(provinceId);
    }

    public List<GeoZone> listDistrictByCity(Long cityId){
        return geoZoneDao.listDistrictByCity(cityId);
    }
}
