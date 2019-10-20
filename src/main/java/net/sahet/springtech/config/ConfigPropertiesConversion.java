package net.sahet.springtech.config;

import lombok.Data;
import net.sahet.springtech.dto.Employee;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@Configuration
@ConfigurationProperties(prefix = "conversion")
public class ConfigPropertiesConversion {
    /**
     * As a result, the field timeInDefaultUnit will have a value of 10 milliseconds and timeInNano will have a value of 9 nanoseconds.
     * <p>
     * The supported units are ns, us, ms, s, m, h and d for nanoseconds, microseconds, milliseconds, seconds, minutes, hours and days respectively.
     */
    private Duration timeInDefaultUnit;
    private Duration timeInNano;

    @DurationUnit(ChronoUnit.DAYS)
    private Duration timeInDays;

    private DataSize sizeInDefaultUnit;

    private DataSize sizeInGB;

    @DataSizeUnit(DataUnit.TERABYTES)
    private DataSize sizeInTB;


    private Employee employee;
}
