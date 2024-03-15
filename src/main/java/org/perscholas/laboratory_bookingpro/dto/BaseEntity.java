package org.perscholas.laboratory_bookingpro.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class BaseEntity implements Serializable {

  @Id
 public String id;
}
