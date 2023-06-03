package edu.uoc.abarrena.notifications.infrastructure.kafka;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class KafkaConstants {
    // misc
    public static final String SEPARATOR = ".";

    // topic items
    public static final String FAVOURITE_SEARCH_TOPIC = "favourite-search";

    public static final String BOOKINGS_TOPIC = "bookings";

    // commands
    public static final String COMMAND_ADD = "add";

    // groups
    public static final String GROUP_ID = "dive-travel";

    // offset
    public static final String OFFSET_RESET = "earliest";
}
