//
//C:\\IMAGE_DATA\\
//
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.io.IOUtils;
//public class IMG {
//
//	@WebServlet(name = "Image", urlPatterns = { "/image" })
//	public class ImageServlet extends HttpServlet {
//
//		final private String IMG_DATA_DIR = "C:\\IMAGE_DATA\\";
//
//		@Override
//		protected void doGet(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			request.setCharacterEncoding("UTF-8");
//			String name = request.getParameter("name");
//			File f = new File(IMG_DATA_DIR + name);
//			response.setContentType("image/*");
//			try (InputStream is = new FileInputStream(f); OutputStream os = response.getOutputStream()) {
//				IOUtils.copy(is, os);
//			}
//
//		}
//	}
//
//
//	Controller
//
//	public String addNews(HttpServletRequest request) {
//			News news = new News();
//			try {
//				BeanUtils.populate(news, request.getParameterMap());
//				Part part = request.getPart("file");
//				String fileName = part.getSubmittedFileName();
//				if(StringUtils.isNotEmpty(fileName)) {
//					news.setImg(fileName);
//				}
//				dao.addNews(news);
//				if(StringUtils.isNotEmpty(fileName)) {
//					part.write(news.getId() + "_" + fileName);
//				}
//			} cathc()
//		}
//		
//	public String deleteNews(HttpServletRequest request) {
//			long aid = Long.parseLong(request.getParameter("aid"));
//			try {
//				News news = dao.getNews(aid);
//				dao.delNews(aid);
//				MultipartConfig mc = getClass().getAnnotation(MultipartConfig.class);
//				String fileName = mc.location() + news.getAid() + "_" + news.getImg();
//				File file = new File(fileName);
//				file.delete();
//		
//		DAO
//		
//		public void addNews(News news) throws Exception{
//			String sql = QM.get("addNews");
//			Connection c = DS.getConnection();
//			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, news.getTitle());
//			ps.setString(2, news.getContent());
//			ps.setString(3, news.getImg());
//			ps.executeUpdate();
//			ResultSet rs = ps.getGeneratedKeys();
//			rs.next();
//			long id = rs.getLong(1);
//			news.setId(id);
//		}
//
//}
