package d12;
public class QueryResult {
    int id=0;
    public String name=null;
    public String password=null;
    public String time=null;

    public QueryResult(int id, String name, String password, String time) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.time = time;
    }

    public QueryResult() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getTime() {
        return time;
    }

}
