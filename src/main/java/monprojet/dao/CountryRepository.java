package monprojet.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

import static org.junit.Assert.assertEquals;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query( value = " SELECT sum(population) as population "
            + " FROM CITY city "
            + " WHERE country_id = :id " ,
            nativeQuery = true)
    public int popPays(Integer id);

    @Query( value = " SELECT name as nom,sum(population) as pop "
            + " FROM CITY city "
            + " WHERE country_id = :id "
            + " Group By name ",
            nativeQuery = true)
    public List<PopParPay> NomPopPays();
}
