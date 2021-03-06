package com.speakout.speakoutapi.customer;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    default OffsetDateTime toOffset(Timestamp value){
        if (value != null){
            return OffsetDateTime.of(value.toLocalDateTime().getYear(), value.toLocalDateTime().getMonthValue(),
                    value.toLocalDateTime().getDayOfMonth(), value.toLocalDateTime().getHour(), value.toLocalDateTime().getMinute(),
                    value.toLocalDateTime().getSecond(), value.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }

    }

    default Timestamp toTimestamp(OffsetDateTime value){
        if(value != null) {
            return Timestamp.valueOf(value.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }
}