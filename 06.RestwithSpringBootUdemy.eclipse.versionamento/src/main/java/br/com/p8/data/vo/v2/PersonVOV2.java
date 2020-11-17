package br.com.p8.data.vo.v2;

import java.io.Serializable;
import java.util.Date;

import br.com.p8.data.vo.PersonVO;

public class PersonVOV2 extends PersonVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date birthDay;

	public PersonVOV2() {
		super();
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVOV2 other = (PersonVOV2) obj;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		return true;
	}
	
	

}
