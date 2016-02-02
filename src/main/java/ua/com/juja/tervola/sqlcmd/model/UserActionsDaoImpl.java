package ua.com.juja.tervola.sqlcmd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 1/26/2016.
 */
@Repository
public class UserActionsDaoImpl implements UserActionsDao{
    private JdbcTemplate template;

    @Autowired
    @Qualifier(value = "logDataSource")
    public void setDataSource(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void log(String username, String dbname, String action) {
        template.update("INSERT INTO public.user_actions" +
                "(user_name, db_name, actions) " +
                "VALUES (?,?,?)",username,dbname,action);
    }

    @Override
    public List<UserAction> getAllFor(String userName) {
        return template.query("SELECT * FROM public.user_actions WHERE user_name = ?", new Object[] {userName} , new RowMapper<UserAction>() {
            @Override
        public UserAction mapRow (ResultSet rs, int rowNum) throws SQLException {
                UserAction result = new UserAction();
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("user_name"));
                result.setDbname(rs.getString("dbname"));
                result.setAction(rs.getString("action"));
                return result;
            }

        });
    }
}
