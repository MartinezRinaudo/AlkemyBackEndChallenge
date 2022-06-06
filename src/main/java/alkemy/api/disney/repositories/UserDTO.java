package alkemy.api.disney.repositories;

import alkemy.api.disney.models.UserModel;

public class UserDTO {

	private Integer id;
	private String userName;
	private String password;

	public UserDTO() {
	}

	public UserDTO(UserModel user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
