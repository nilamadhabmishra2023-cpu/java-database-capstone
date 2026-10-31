@PostMapping
public ResponseEntity<?> createPrescription(
        @RequestHeader("Authorization") String token,
        @Valid @RequestBody Prescription prescription) {

    if (token == null || !token.startsWith("Bearer ")) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of(
                    "status", "error",
                    "message", "Invalid authentication token"
                ));
    }

    Prescription saved = prescriptionService.save(prescription);

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(Map.of(
                "status", "success",
                "message", "Prescription saved successfully",
                "data", saved
            ));
}
