import logo from "./logo.svg";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import { Link, useNavigate } from "react-router-dom";
import RegisterUser from "./pages/register";
import SearchUser from "./pages/search";
import Home from "./pages/home";

import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import SearchResult from "./pages/result";

function App() {
  return (
    <div className="container">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<RegisterUser />} />
        <Route path="/home" element={<Home />} />
        {/* <Route path="/result" element={<SearchResult />} /> */}
        <Route path="/search" element={<SearchUser />} />
      </Routes>

      <ToastContainer />
    </div>
  );
}

export default App;
