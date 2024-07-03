

using Microsoft.Data.SqlClient;


namespace ExamApp.Models
{
    public interface Iuserdbcontext
    {
        int AddUser(user user);
        List<user> GetUsers();
        int RemoveUser(int id);
        user Search(int Id);
        int UpdateUser(user updateduser);
    }

    public class userdbcontext : Iuserdbcontext
    {
        public List<user> GetUsers()
        {
            List<user> users = new List<user>();
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            SqlCommand cmd = new SqlCommand("select * from user1", conn);
            conn.Open();

            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                user user = new user();
                user.name = reader["username"].ToString();
                user.email = reader["email"].ToString();
                user.mobile = Convert.ToInt32(reader["mobileno"]);
                user.password = reader["password"].ToString();
                users.Add(user);
            }
            conn.Close();
            return users;
        }

        public int AddUser(user user)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            string queryTextFormat = "insert into user1(username, email, mobileno, password, role) values('{0}', '{1}', '{2}','{3}','{4}')";
            string query = string.Format(queryTextFormat, user.name, user.email, user.mobile, user.password, user.role);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();

            int rowsAffected = cmd.ExecuteNonQuery();
            conn.Close();
            return rowsAffected;

        }



        public int UpdateUser(user updateduser)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            string queryTextFormat = "Update user1 set username='{1}', email='{2}', mobileno='{3}', password='{4}', role='{5}' where userId={0}";

            string query = string.Format(queryTextFormat, updateduser.id, updateduser.name, updateduser.email, updateduser.mobile, updateduser.password, updateduser.role);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();

            int rowsAffected = cmd.ExecuteNonQuery();
            conn.Close();
            return rowsAffected;

        }


        public int RemoveUser(int id)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");

            string queryTextFormat = "Delete from user1 where userId= {0}";
            string query = string.Format(queryTextFormat, id);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();
            int rowsAffected = cmd.ExecuteNonQuery();
            return rowsAffected;
        }

        public user Search(int Id)
        {
            List<user> users = GetUsers();

            user userToEdit = (from user in users
                               where user.id == Id
                               select user).First();

            return userToEdit;
        }





    }
}
