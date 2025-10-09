package DTADAO;

import java.util.ArrayList;

public interface GeneralDAO<T> {
	public T findByPrimaryKey(String UserId);
	public ArrayList<T> findAll();
	
	//For Read-Write DTO-DAO
	public void save(T dto)throws Exception;
	public void update(T dto)throws Exception;
	public void delete(T dto)throws Exception;
}
