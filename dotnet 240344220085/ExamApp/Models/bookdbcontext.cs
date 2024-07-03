

using Microsoft.Data.SqlClient;


namespace ExamApp.Models
{
    public interface Ibookdbcontext
    {
        int AddBook(book book);
        List<book> GetBooks();
        int RemoveUser(int id);
        book Search(int Id);
        int UpdateBook(book book);
    }

    public class bookdbcontext : Ibookdbcontext
    {
        public List<book> GetBooks()
        {
            List<book> books = new List<book>();
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            SqlCommand cmd = new SqlCommand("select * from book", conn);
            conn.Open();

            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                book book = new book();
                book.bname = reader["bname"].ToString();
                book.author = reader["author"].ToString();
                book.category = reader["category"].ToString();
                book.price = Convert.ToInt32(reader["price"]);
                book.userid = (user)(reader["user1id"]);
                books.Add(book);
            }
            conn.Close();
            return books;
        }

        public int AddBook(book book)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            string queryTextFormat = "insert into book(bname, author, category, price, user1id) values('{0}', '{1}', '{2}','{3}','{4}')";
            string query = string.Format(queryTextFormat, book.bname, book.author, book.category, book.price, book.userid);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();

            int rowsAffected = cmd.ExecuteNonQuery();
            conn.Close();
            return rowsAffected;

        }



        public int UpdateBook(book book)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");
            string queryTextFormat = "Update user1 set username='{1}', email='{2}', mobileno='{3}', password='{4}', role='{5}' where userId={0}";

            string query = string.Format(queryTextFormat, book.bookid, book.bname, book.author, book.category, book.price, book.userid);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();

            int rowsAffected = cmd.ExecuteNonQuery();
            conn.Close();
            return rowsAffected;

        }


        public int Removebook(int id)
        {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Student;Integrated Security=True;");

            string queryTextFormat = "Delete from book where bookId = {0}";
            string query = string.Format(queryTextFormat, id);

            SqlCommand cmd = new SqlCommand(query, conn);
            conn.Open();
            int rowsAffected = cmd.ExecuteNonQuery();
            return rowsAffected;
        }

        public book Search(int Id)
        {
            List<book> books = GetBooks();

            book bookToEdit = (from book in books
                               where book.bookid == Id
                               select book).First();

            return bookToEdit;
        }





    }
}
