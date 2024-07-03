package interfaces;

import java.sql.SQLException;
import java.util.List;
import com.entity.account;
import com.entity.user;

public interface Operations {

    void addUser(user user) throws SQLException;
    
    void addAccount(account account) throws SQLException;

    List<account> displayAccount(int user_id) throws SQLException;

    void deleteUser(int user_id) throws SQLException;

    List<account> searchAccount(String name) throws SQLException;
}
