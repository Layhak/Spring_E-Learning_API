package co.istad.jbsdemo.spring_elearning_api.feature.city;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCitiesSortedByName() {
        return cityRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<City> getCitiesByCountryIso(String iso) {
        return cityRepository.findByCountry_Iso(iso);
    }
}