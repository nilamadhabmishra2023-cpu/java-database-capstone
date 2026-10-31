@GetMapping("/availability")
public ResponseEntity<?> getDoctorAvailability(
        @RequestParam Long doctorId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @RequestHeader("Authorization") String token) {

    if (!token.startsWith("Bearer ")) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid authentication token");
    }

    return ResponseEntity.ok(
            doctorService.getAvailability(doctorId, date)
    );
}
