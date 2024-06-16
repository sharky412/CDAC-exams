import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="home">
      <h1>Welcome to Our Application</h1>
      <p>Please register or login to continue.</p>
      <div className="home-buttons">
        <Link to="/register">
          <button className="btn btn-primary">Register</button>
        </Link>
        <Link to="/search">
          <button className="btn btn-secondary">Search</button>
        </Link>
      </div>
    </div>
  );
}

export default Home;
