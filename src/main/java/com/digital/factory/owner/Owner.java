package com.digital.factory.owner;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.digital.factory.command.Command;
import com.digital.factory.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Owner extends User {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Command> commands;
}
