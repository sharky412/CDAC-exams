using ExamApp.Models;
using Microsoft.AspNetCore.Mvc;

namespace ExamApp.Controllers
{
    public class HomeController1 : Controller
    {
        Ibookdbcontext bookdbcontext = null;
        


        public HomeController1(Ibookdbcontext _bookdbcontext)
        {
            bookdbcontext = _bookdbcontext;
        }

        public IActionResult bookIndex()
        {
            List<book> books = bookdbcontext.GetBooks();
            return View(books);
        }
    }
}
