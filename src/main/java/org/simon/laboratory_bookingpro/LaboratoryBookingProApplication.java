package org.simon.laboratory_bookingpro;

import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.repository.UserRepository;
import org.simon.laboratory_bookingpro.service.LabLocationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Arrays;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LaboratoryBookingProApplication implements CommandLineRunner {

	private final LabLocationService locationService;
	final UserRepository userRepository;

	public LaboratoryBookingProApplication(LabLocationService locationService, UserRepository userRepository) {
        this.locationService = locationService;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(LaboratoryBookingProApplication.class, args);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		//initLocation();
		//initUsers();
	}

	public void initLocation(){
		locationService.createLabLocation(new LabLocation("DC", 20002));
		locationService.createLabLocation(new LabLocation("MD", 20782));
		locationService.createLabLocation(new LabLocation("VA", 20878));
	}

	private void initUsers()
	{
		//Login 'admin@admin.com'
		//Password 'admin'

		userRepository.save(new UserDto("Jack", "Smith", "admin@admin.com", "998-098-0987", "admin"));

//		UserDto user=  userRepository.findByEmail("admin@admin.com");
//		user.setRoles(Arrays.asList(roleService.findRoleByRoleName("ROLE_ADMIN")));
//		userRepository.save(user);


	}
}
