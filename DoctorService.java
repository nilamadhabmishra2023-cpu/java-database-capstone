@Service
public class DoctorService {

    public List<String> getAvailableTimeSlots(
            Long doctorId, LocalDate date) {
        // Retrieve available slots for the doctor
        // Exclude already booked appointments
        return doctorRepository.findAvailableSlots(doctorId, date);
    }

    public Map<String, Object> validateDoctorLogin(
            String email, String password) {

        Optional<Doctor> doctor =
                doctorRepository.findByEmail(email);

        if (doctor.isPresent()
                && passwordEncoder.matches(
                    password, doctor.get().getPassword())) {

            return Map.of(
                "status", "success",
                "message", "Doctor login successful"
            );
        }

        return Map.of(
            "status", "error",
            "message", "Invalid email or password"
        );
    }
}
