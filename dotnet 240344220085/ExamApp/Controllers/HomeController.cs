using System.Diagnostics;
using ExamApp.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class HomeController : Controller
    {
        Iuserdbcontext dbContext = null;
        
        public HomeController(Iuserdbcontext _dbContext)
        {
            dbContext = _dbContext;
        }
        


        public IActionResult Index()
        {
            List<user> users = dbContext.GetUsers();
            return View(users);
        }

       

        
        public ViewResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(user user)
        {
            int rowsAffected = dbContext.AddUser(user);
            if (rowsAffected > 0)
            {
                return Redirect("/Home/Index");
            }
            else
            {
                return Redirect("/Home/Index");
            }
        }

        public IActionResult Update(int id)
        {
            try
            {
                user userToEdit = dbContext.Search(id);
                if (userToEdit != null)
                {
                    return View(userToEdit);
                }
                else
                {
                    return Redirect("/Home/Index");
                }
            }
            catch (Exception ex)
            {
                return View("ErrorView", ex);
            }
        }

        public IActionResult AfterUpdate(user userToEdit)
        {
            int rowAffected = dbContext.UpdateUser(userToEdit);
            if (rowAffected > 0)
            {
                return Redirect("/Home/Index");
            }
            else
            {
                return null;
            }
        }

        public IActionResult Delete(int id)
        {
            int rowAffected = dbContext.RemoveUser(id);
            if (rowAffected > 0)
            {
                return Redirect("/Home/Index");
            }
            else
            {
                return null;
            }

        }



    }
}
