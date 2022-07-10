package cf.mindaugas._03_patterns._01_Creational;


class DbConnection {
    private static DbConnection instance = null;
    private String username;
    private String password;

    private DbConnection(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static DbConnection getInstance(String username, String password) {
        if (instance == null) {
            instance = new DbConnection(username, password);
        }
        return instance;
    }
}



class Config {
    private static Config instance;
    private String url;
    private String password;
    private Config(String url) { this.url = url; }
    public static Config getInstance(String url) {
        synchronized (Config.class){ // t0 executes, t1 waits
            if(instance == null){
                instance = new Config(url);
            }
            return instance;
        }
    }
    @Override
    public String toString() {
        return "Config{url='" + url + "'}";
    }
}

public class _02_Singleton {
    public static void main(String[] args) {
        // new Config("http://delfi.ee");
        // new Config("http://delfi.lv");


        // ... to test singleton we need to prove that there is no ability to create another object
        var config0 = Config.getInstance("http://delfi.lv");
        System.out.println(config0);

        var config1 = Config.getInstance("http://delfi.ee");
        System.out.println(config1);
    }
}
