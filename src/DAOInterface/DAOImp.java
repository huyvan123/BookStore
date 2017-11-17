package DAOInterface;

public interface DAOImp<T> {
	void addObject(T a);

	void deleteObject(T a);

	void updateObject(T a);

	int getLastID();

	boolean checkExist(T a);
	
	int getFirstID();
	
	void Connect();
	
	void Disconnect();

}
