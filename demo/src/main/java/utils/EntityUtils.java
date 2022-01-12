package utils;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;

public interface EntityUtils<T> {
	
	public T findEntity(long id) throws EntityDoesNotExistException;
	public boolean deleteEntity(T t) throws EntityDoesNotExistException;
	public T createEntity(T t) throws EntityAlreadyExistsException;
	public boolean updateEntity(T t) throws EntityDoesNotExistException;
	public void initializeTable(DefaultTableModel table);
	public List<T> getAllEntities();

}
