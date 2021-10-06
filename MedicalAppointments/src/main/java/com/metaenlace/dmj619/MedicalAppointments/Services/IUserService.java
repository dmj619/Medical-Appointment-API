package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;

import com.metaenlace.dmj619.MedicalAppointments.Models.User;

public interface IUserService {
	
	public List<User> GetAllUsers();

    public User GetUserById(Long idUser);

    public User AddUsuario(User user);

    public User DeleteUser(Long idUser);
}
