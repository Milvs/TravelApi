package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import com.example.travelapi.entities.Holiday;
import com.example.travelapi.entities.Location;
import com.example.travelapi.repositories.HolidayRepository;
import com.example.travelapi.repositories.LocationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;
    private final EntityManager em;

    @Transactional
    @Override
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {
        Location location = locationRepository.findById(createHolidayDTO.getLocation()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Location not found for id = %s", createHolidayDTO.getLocation());
            return new IllegalArgumentException(errorMessage);
        });

        Holiday holiday = Holiday.builder().price(createHolidayDTO.getPrice())
                .title(createHolidayDTO.getTitle())
                .freeSlots(createHolidayDTO.getFreeSlots())
                .startDate(createHolidayDTO.getStartDate())
                .duration(createHolidayDTO.getDuration())
                .location(location)
                .build();

        holidayRepository.save(holiday);

        return modelMapper.map(holiday, ResponseHolidayDTO.class);

    }

    @Transactional
    @Override
    public void deleteHolidayById(Long id) {
        Holiday holiday = holidayRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", id);
            return new IllegalArgumentException(errorMessage);
        });

        holidayRepository.delete(holiday);
    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidaysByFilters(String city, String country, Date startDate, Integer duration) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Holiday> cq = cb.createQuery(Holiday.class);
        Root<Holiday> holidayRoot = cq.from(Holiday.class);

        List<Predicate> predicates = new ArrayList<>();

        if (country != null || city != null) {
            Join<Holiday, Location> locationJoin = holidayRoot.join("location", JoinType.LEFT);

            Predicate countryPredicate = cb.equal(locationJoin.get("country"), country);
            Predicate cityPredicate = cb.equal(locationJoin.get("city"), city);
            predicates.add(cb.or(countryPredicate, cityPredicate));
        }

        if (startDate != null) {
            predicates.add(cb.equal(holidayRoot.get("startDate"), startDate));
        }
        if (duration != null) {
            predicates.add(cb.equal(holidayRoot.get("duration"), duration));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        List<Holiday> holidays = em.createQuery(cq).getResultList();

        return holidays.stream().map(h -> modelMapper.map(h, ResponseHolidayDTO.class))
                .toList();
    }

    @Override
    public ResponseHolidayDTO getHolidayById(Long id) {
        Holiday holiday = holidayRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", id);
            return new IllegalArgumentException(errorMessage);
        });

        return modelMapper.map(holiday, ResponseHolidayDTO.class);
    }

    @Transactional
    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHoliday) {
        Holiday holiday = holidayRepository.findById(updateHoliday.getId()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", updateHoliday.getId());
            return new IllegalArgumentException(errorMessage);
        });

        Location location = locationRepository.findById(updateHoliday.getLocation()).orElseThrow();
        holiday.setPrice(updateHoliday.getPrice());
        holiday.setDuration(updateHoliday.getDuration());
        holiday.setLocation(location);
        holiday.setStartDate(updateHoliday.getStartDate());
        holiday.setTitle(updateHoliday.getTitle());
        holidayRepository.save(holiday);

        return modelMapper.map(holiday, ResponseHolidayDTO.class);
    }
}



