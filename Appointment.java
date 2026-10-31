@ManyToOne
@JoinColumn(name = "doctor_id", nullable = false)
private Doctor doctor;

@ManyToOne
@JoinColumn(name = "patient_id", nullable = false)
private Patient patient;

@NotNull(message = "Appointment time is required")
@Future(message = "Appointment time must be in the future")
private LocalDateTime appointmentTime;
