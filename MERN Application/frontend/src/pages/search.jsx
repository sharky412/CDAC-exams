import React, { useState } from "react";
import { search } from "../services/user";
import { toast } from "react-toastify";
import SearchResult from "./result";

function SearchUser() {
  const [email, setEmail] = useState("");
  const [searchResult, setSearchResult] = useState("");

  const onSearch = async () => {
    if (email.length === 0) {
      toast.warning("Enter email");
    } else {
      const result = await search(email);
      if (result.status === "success") {
        toast.success("User found successfully");
        setSearchResult(result.data); // Ensure this is correctly setting the state
      } else {
        toast.error(result.error);
      }
    }
  };

  return (
    <div>
      <h1>Search</h1>
      <div>
        <label htmlFor="Email">Email :</label>
        <input onChange={(e) => setEmail(e.target.value)} type="email" placeholder="abc@gmail.com" id="Email" />
      </div>
      <button className="btn btn-success" onClick={onSearch} style={{ marginInline: "5%" }}>
        Search
      </button>
      {searchResult && <SearchResult result={searchResult} />}
    </div>
  );
}

export default SearchUser;
