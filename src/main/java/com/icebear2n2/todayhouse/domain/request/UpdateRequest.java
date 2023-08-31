package com.icebear2n2.todayhouse.domain.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UpdateRequest(String password, String username, LocalDate birth) {

}
