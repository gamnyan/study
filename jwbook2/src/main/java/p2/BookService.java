package p;

import java.util.List;

public class BookService {
	BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}
	
	public List<Book> get(){
		return bookDao.select();
	}
	
	public Book get(int id) {
		return bookDao.selectById(id);
	}
}
