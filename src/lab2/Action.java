package lab2;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class Action {
    ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    private Pattern p = Pattern.compile("\\?");
    private List<String> list = new LinkedList<String>();
    private List<String> list0 = new LinkedList<String>();
    private String username;
    private String title;
    private String isbn;
    private String name;
    private String publisher;
    private String publishdate;
    private String price;
    private String age;
    private String country;
    private String authorid;
    static int flag;
    public String getUsername(){
        return username;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getName(){
        return name;
    }
    public String getAuthorid(){
        return authorid;
    }
    public String execute() {
        String sql0 ="select AuthorID from Author where Name=?";
        Matcher m1 = p.matcher(sql0);
        String sql1 = m1.replaceFirst('"'+username+'"');
        DBConnection connect = new DBConnection();
        list0=connect.select(sql1);
        if(list0.size() == 0)
            return "FAILED";
        String sql2 ="select Title from Book where AuthorID=?";
        Matcher m2 = p.matcher(sql2);
        String sql = m2.replaceFirst('"'+list0.get(0)+'"');
        list=connect.select(sql);
        session.setAttribute("list", list);
        session.setAttribute("username",username);
        if(list.size() == 0)
            return "FAILED";
        else
            return "SUCCESS";
    }
    public String detail(){
        String sql0 ="select * from Author where Name=?";
        Matcher m1 = p.matcher(sql0);
        String sql1 = m1.replaceFirst('"'+username+'"');
        DBConnection connect = new DBConnection();
        list0=connect.select(sql1);
        session.setAttribute("list0", list0);
        String sql2 ="select * from Book where Title=?";
        Matcher m2 = p.matcher(sql2);
        String sql3 = m2.replaceFirst('"'+title+'"');
        list=connect.select(sql3);
        session.setAttribute("list", list);
        if(list.size()==0)
            return "FAILED";
        else
            return "SUCCESS";
    }
    public String delete(){
        String sql0 ="delete from Book where ISBN=?";
        Matcher m1 = p.matcher(sql0);
        String sql1 = m1.replaceFirst('"'+isbn+'"');
        DBConnection connect = new DBConnection();
        int signal=connect.delete(sql1);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setName(String name) {
        this.name =name;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setCountry(String country) {
        this.country=country;
    }//dd


}
