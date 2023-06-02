package edu.uoc.abarrena.notifications.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

        public EntityNotFoundException(String message) {
            super(message);
        }
}
