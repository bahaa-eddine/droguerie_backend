package com.digital.factory.supplier;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.digital.factory.command.Command;
import com.digital.factory.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Supplier extends User {

	@OneToMany
	private List<Command> commands;
}
