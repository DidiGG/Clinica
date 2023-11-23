package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final AppointmentRepo appointmentRepo;

    private final SpecializationRepo specializationRepo;

    private final AllergyRepo allergyRepo;
    private final EpsRepo epsRepo;

    private final ProfileRepo profileRepo;

    private final LevelAccessRepo levelAccessRepo;
    private  MailServiceImpl mailService;


    public UserServiceImpl(UserRepo userRepo, AppointmentRepo appointmentRepo, SpecializationRepo specializationRepo, AllergyRepo allergyRepo, EpsRepo epsRepo, LevelAccessRepo levelAccessRepo, ProfileRepo profileRepo, MailServiceImpl mailService) {
        this.userRepo = userRepo;
        this.appointmentRepo = appointmentRepo;
        this.specializationRepo = specializationRepo;
        this.allergyRepo = allergyRepo;
        this.epsRepo = epsRepo;
        this.levelAccessRepo = levelAccessRepo;
        this.profileRepo = profileRepo;
        this.mailService = mailService;
    }


    public Boolean registerUser(UserRegisterRequestDTO newUserInfo) throws Exception {

        validateUserRegisterDTO(newUserInfo);

        User newUser = new User();
        newUser.setEmail(newUserInfo.getEmail());
        newUser.setPassword(newUserInfo.getPassword());

        Profile newProfile = new Profile();
        newProfile.setIdNumber(newUserInfo.getIdNumber());
        newProfile.setNames(newUserInfo.getNames());
        newProfile.setLastNames(newUserInfo.getLastNames());
        newProfile.setUser(newUser);


        Optional<LevelAccess> levelAccess = levelAccessRepo.findByAccessCode(2);
        if (levelAccess.isPresent()){
            newUser.setLevelAccess(levelAccess.get()) ;
            userRepo.save(newUser);
            profileRepo.save(newProfile);
            //mailService.sendEmailVerification(newUser.getEmail(),newProfile.getNames(), TokenUtils.encriptAES(newUser.getEmail()));
            return  true ;
        }else{
            throw new Exception("Ocurrió un error al asignar el nivel de acceso");
        }
    }

    @Override
    public Boolean registerUserPatient(UserRegisterRequestDTO patientInfo) throws Exception {
        validateRegisterPatientInfo(patientInfo);
        ArrayList<Alergia> allergiesList = new ArrayList<>();
        User user = generateUser(patientInfo);
        userRepo.save(user);
        Profile profile = generateProfile(patientInfo,user);

        Integer[] allergies = patientInfo.getAllergies();
            for (Integer idAllergie:allergies
            ) {
                Optional<Alergia> allergy = allergyRepo.findById(idAllergie);
                if(allergy.isPresent()){
                    allergiesList.add(allergy.get());
                }
            }
        profile.setAlergiaList(allergiesList);
        profileRepo.save(profile);
        return true;
    }

    private void validateRegisterPatientInfo(UserRegisterRequestDTO patientInfo) throws Exception {
        validBasicUserInfo(patientInfo);
    }

    private void validBasicUserInfo(UserRegisterRequestDTO basicUserInfo) throws Exception {
        Integer totalUsers = userRepo.countByEmail(basicUserInfo.getEmail());
        Integer totalProfilesWithIdNumner = profileRepo.countProfileByIdNumber(basicUserInfo.getIdNumber());
        if(totalUsers != 0){
            throw new Exception("El correo ya está en uso");
        }
        if(totalProfilesWithIdNumner != 0){
            throw new Exception("La identificación ya está en uso");
        }
    }

    private void validateRegisterMedicInfo(UserRegisterRequestDTO medicInfo) throws Exception {
        validBasicUserInfo(medicInfo);
        if(medicInfo.getConsultingRoom() == null)
            throw new Exception("Debe ingresarse un consultorio en los datos de registro");
    }

    @Override
    public Boolean registerUserMedic(UserRegisterRequestDTO medicInfo) throws Exception {
        validateRegisterMedicInfo(medicInfo);
        User user = generateUser(medicInfo);
        userRepo.save(user);
        Profile profile = generateProfile(medicInfo,user);
        profile.setConsulting_room(medicInfo.getConsultingRoom());
        profileRepo.save(profile);
        return true;
    }

    @Override
    public List<MedicAppointmentDTO> getAllMedicAppointmentsByEmail(String email) throws Exception {
        List<MedicAppointmentDTO> appointmentList =  new ArrayList<>();
        Optional<User> medicOptional = userRepo.findByEmail(email);

        if(medicOptional.isEmpty()){
            throw  new Exception("Médico no encontrado");
        }
        User medic = medicOptional.get();

        List<Cita> cites = medic.getProfile().getCitaAsMedicoList();
        for (Cita cita:cites) {
            MedicAppointmentDTO appointmentItem = new MedicAppointmentDTO();
            String specializationName = cita.getEspecializacion().getTitulo();
            Profile patient = cita.getPaciente();
            ClientBasicInfoDTO patientInfo = generatePatientInfoDTO(patient);
            CitaBasicInfo citaBasicInfo = generateCitaBasicInfo(cita);
            String epsName = patient.getEps().getNombre();

            appointmentItem.setAppointmentInfo(citaBasicInfo);
            appointmentItem.setEspecialization(specializationName);
            appointmentItem.setEpsName(epsName);
            appointmentItem.setPatientInfo(patientInfo);

            appointmentList.add(appointmentItem);

        }
        return appointmentList;
    }

    private CitaBasicInfo generateCitaBasicInfo(Cita cita) {
        CitaBasicInfo citaBasicInfo = new CitaBasicInfo();

        citaBasicInfo.setHour(cita.getHora_cita());
        citaBasicInfo.setState(cita.getEstado_cita());
        citaBasicInfo.setReason(cita.getMotivo_consulta());
        citaBasicInfo.setAppointment_date(cita.getFechac_cita());
        citaBasicInfo.setCreated_at(cita.getFecha_creacion());

        return citaBasicInfo;
    }

    private ClientBasicInfoDTO generatePatientInfoDTO(Profile patient) {
        ClientBasicInfoDTO clientBasicInfoDTO = new ClientBasicInfoDTO();
        ArrayList<String> allergies = new ArrayList<>();
        clientBasicInfoDTO.setName(patient.getNames() + " "+patient.getLastNames());
        clientBasicInfoDTO.setGender(patient.getGender());
        for (Alergia allergy:patient.getAlergiaList()
             ) {
            allergies.add(allergy.getNombre_alergia());
        }
        clientBasicInfoDTO.setAlergiesNames(allergies);
        return clientBasicInfoDTO;
    }

    private Profile generateProfile(UserRegisterRequestDTO profileInfo,User user) {
        Profile profile = new Profile();
        Optional<Eps> eps = epsRepo.findById(profileInfo.getEps());
        if(eps.isPresent()){
            profile.setEps(eps.get());
        }
        profile.setGender(profileInfo.getGender());
        profile.setIdNumber(profileInfo.getIdNumber());
        profile.setLastNames(profileInfo.getLastNames());
        profile.setNames(profileInfo.getNames());
        profile.setPhoneNumber(Integer.parseInt(profileInfo.getPhoneNumber()));
        profile.setUser(user);
        return profile;
    }

    private User generateUser(UserRegisterRequestDTO userInfo) {
        User user = new User();
        user.setEmail(userInfo.getEmail());
        user.setPassword(userInfo.getPassword());
        if(userInfo.getRol().equalsIgnoreCase("PACIENTE")){
            user.setLevelAccess(levelAccessRepo.findLevelAccessByName("PACIENTE"));
        }else{
            user.setLevelAccess(levelAccessRepo.findLevelAccessByName("MEDICO"));
        }
        return user;
    }


    @Override
    public User updateUser(User u) throws Exception {
        return userRepo.save(u);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginInfo) throws Exception {
        Optional<User> user = userRepo.findByEmailAndPassword(loginInfo.getEmail(),loginInfo.getPassword());
        if (user.isEmpty()) {
            throw new Exception("Usuario no existe");
        }
        User foundUser = user.get();

        String userName = foundUser.getProfile().getNames();
        String userEmail = foundUser.getEmail();
        LevelAccess levelAccess = foundUser.getLevelAccess();
        Integer accessCode = levelAccess.getAccessCode();
        String  accessDescription = levelAccess.getDescription();
        String accessName = levelAccess.getName();

        LoginResponseDTO responseDTO = new LoginResponseDTO(null,userEmail,accessName,accessCode,accessDescription,userName);

        return responseDTO;
    }

    @Override
    public void createPatientAppointment(PatientCreateAppointmentRequestDTO appointmentInfo, String email)throws Exception {

        Optional<User> userOptional = userRepo.findByEmail(email);
        Optional<User> medicOptional = userRepo.findById(appointmentInfo.getMedicId());
        Profile patient = null;
        Profile medic = null;
        Cita appointment = null;

        if (userOptional.isEmpty())
            throw new Exception("usuario no encontrado");
        if(medicOptional.isEmpty())
            throw new Exception("médico no encontrado");

        patient = userOptional.get().getProfile();
        medic = medicOptional.get().getProfile();
        appointment = generateAppointment(appointmentInfo,patient,medic);
        appointmentRepo.save(appointment);
    }

    private Cita generateAppointment(PatientCreateAppointmentRequestDTO appointmentInfo, Profile patient, Profile medic) {
        Cita appointment = new Cita();
        Optional<Especializacion> specializacionOptional = specializationRepo.findById(appointmentInfo.getSpecialization());

        if (specializacionOptional.isPresent())
            appointment.setEspecializacion(specializacionOptional.get());

        appointment.setMedico(medic);
        appointment.setPaciente(patient);

        appointment.setEstado_cita("PENDIENTE");
        appointment.setFecha_creacion("2023-11-23");
        appointment.setFechac_cita(appointmentInfo.getAppointment_date());
        appointment.setHora_cita(appointmentInfo.getHour());
        appointment.setMotivo_consulta(appointmentInfo.getReason());


        return appointment;

    }

    public void validateUserRegisterDTO(UserRegisterRequestDTO userRegister) throws Exception {
        Optional<User> searched = userRepo.findByEmail(userRegister.getEmail());
        if (searched.isPresent()){
            throw new Exception("El correo del usuario ya existe");
        }
        Optional<Profile> profileSearched = profileRepo.findByIdNumber(userRegister.getIdNumber());
        if (profileSearched.isPresent()){
            throw new Exception("La identificacion de usuario ya existe");
        }
    }

}
