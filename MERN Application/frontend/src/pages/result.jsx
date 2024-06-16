import React from "react";

function SearchResult({ result }) {
  return (
    <div>
      <h2>Search Result</h2>
      <p>
        <strong>Name:</strong> {result.name}
      </p>
      <p>
        <strong>Address:</strong> {result.address}
      </p>
    </div>
  );
}

export default SearchResult;
