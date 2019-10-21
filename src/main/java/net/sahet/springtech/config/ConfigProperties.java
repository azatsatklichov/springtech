package net.sahet.springtech.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sahet.springtech.web.dto.Credentials;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Configuration
/**
 * Note: If we don't use @Configuration in the POJO, then we need to add @EnableConfigurationProperties(ConfigProperties.class) in the main
 * Spring application class to bind the properties into the POJO:
 *
 * Spring will automatically bind any property defined in our property file that has the prefix mail and the same name as one of the fields in the ConfigProperties class.
 *
 * Spring uses some relaxed rules for binding properties. So the following variations are all bound to the property hostName:
 *
 * <pre>
 * mail.hostName
 * mail.hostname
 * mail.host_name
 * mail.host-name
 * mail.HOST_NAME
 * </pre>
 *
 *
 * Nested Properties -  We can have nested properties in Lists, Maps, and Classes.
 *
 */
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {

    //@NotBlank
    @NotEmpty(message="firstName is required")
    private String hostName;

    @Min(1025)
    @Max(65536)
    private int port;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

    @Length(max = 4, min = 1)
    private String authMethod;

}
