package org.simon.laboratory_bookingpro.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class BaseEntity implements Serializable {

  @Id
 public String id;
}
