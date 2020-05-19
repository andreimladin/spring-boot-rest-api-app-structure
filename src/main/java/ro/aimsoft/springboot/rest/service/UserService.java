package ro.aimsoft.springboot.rest.service;

import com.aimsoft.cnas.rest.client.api.DefaultApi;
import com.aimsoft.cnas.rest.client.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.aimsoft.springboot.rest.exception.business.PatientNotAssurredException;
import ro.aimsoft.springboot.rest.model.dto.UserCreationDTO;
import ro.aimsoft.springboot.rest.model.dto.UserDTO;
import ro.aimsoft.springboot.rest.model.entity.User;
import ro.aimsoft.springboot.rest.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DefaultApi patientApi;

    public void createUser(UserCreationDTO userDTO) {
        if (isAssurred(userDTO)) {
            User user = modelMapper.map(userDTO, User.class);
            user.setId(UUID.randomUUID());

            userRepo.save(user);
        } else {
            throw new PatientNotAssurredException();
        }
    }

    private boolean isAssurred(UserCreationDTO userDTO) {
        Patient patient = patientApi.getPatientByCNP(userDTO.getCnp());
        return Patient.StatusEnum.NEASIGURAT != patient.getStatus();
    }

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(UUID id) {
        return userRepo.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(EntityNotFoundException::new);
    }
}
