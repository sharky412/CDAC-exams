namespace ExamApp.Models
{
    public class book
    {
        public int bookid { get; set; }
        public string bname { get; set; }
        public string author { get; set; }
        public string category {  get; set; }

        public int price { get; set; }
        public user userid { get; set; }
    }


}
