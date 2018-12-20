package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("AVIO")
public class AvioAdmin extends User {
	
}
