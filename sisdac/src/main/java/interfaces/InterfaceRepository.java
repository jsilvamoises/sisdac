package interfaces;

import java.util.List;

public interface InterfaceRepository {
	public boolean save(Object object);
	public boolean saveOrUpdate(Object object);
	public boolean merge(Object object);	
	public boolean remove(Object object);
	public Object getById(Long id);
	public List<Class<?>>	 listAll();

}
