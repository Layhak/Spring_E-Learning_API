package co.istad.jbsdemo.spring_elearning_api.feature.country;

import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountriesSortedByName() {
        return countryRepository.findAllByOrderByNameAsc();
    }
}
