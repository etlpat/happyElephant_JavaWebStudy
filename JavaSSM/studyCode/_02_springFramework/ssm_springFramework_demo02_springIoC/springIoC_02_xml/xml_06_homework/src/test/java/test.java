import com.etlpat.javaBean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class test {

    @Test
    public void test01() {
        // (1)创建ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml_06.xml");


        // (2)从ioc容器中，获取jdbcTemplate对象，用于操纵数据库
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);


        // (3)进行数据库的CRUD
        // ①insert语句
//        String sql1 = "INSERT INTO students (id, NAME, gender, age, class) VALUES(?,?,?,?,?)";
//        jdbcTemplate.update(sql1, 9, "二狗蛋", "男", 18, "一年一班");


//        // ②查询一行的语句
        String sql2 = "select * from students where name=?";
        Student student = jdbcTemplate.queryForObject(sql2, new RowMapper<Student>() {
            // 映射列名与属性值
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, "二狗蛋");
        System.out.println(student);
        System.out.println("==============================");

        // ③查询整表的语句
        String sql3 = "select id,name,gender,age,class as classes from students";
        // 当列名（取别名后）与属性名相同时，直接使用BeanPropertyRowMapper直接映射二者
        List<Student> query = jdbcTemplate.query(sql3, new BeanPropertyRowMapper<Student>(Student.class));
        // 打印整个表
        for (Student s : query) {
            System.out.println(s);
        }
    }
}
