
      Class.forName("com.mysql.cj.jdbc.Driver");
      cn = DriverManager.getConnection("jdbc:mysql://localhost/colegio?"
              + "useUnicode=true&useJDBCCompliantTimezoneShift=true&"
              + "useLegacyDatetimeCode=false&serverTimezone=UTC&"
              + "user=root&password=");
