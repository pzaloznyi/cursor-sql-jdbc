package config;

public class DbConfig {

    public String getUrl() {
        return "jdbc:sqlserver://localhost:1433;database=WideWorldImporters;encrypt=true;trustServerCertificate=true;";
    }

    public String getUser() {
        return "sa";
    }

    public String getPassword() {
        return "mssql1Ipw";
    }
}
