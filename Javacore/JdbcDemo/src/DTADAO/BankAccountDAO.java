package DTADAO;

import java.util.ArrayList;

public interface BankAccountDAO {
	public BankAccountDTO findByPrimaryKey(String UserId);
	public ArrayList<BankAccountDTO> findAll();
	
	//For Read-Write DTO-DAO
	public void save(BankAccountDTO dto)throws Exception;
	public void update(BankAccountDTO dto)throws Exception;
	public void delete(BankAccountDTO dto)throws Exception;
	
}
