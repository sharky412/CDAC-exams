const express = require("express");
const db = require("../db");
const utils = require("../utils");

const router = express.Router();

router.get("/home", (request, response) => {
  const query = `select * from Customer_TB;`;
  db.pool.execute(query, (error, result) => {
    if (error) {
      response.send(utils.createErrorResult(error));
    } else {
      response.send(utils.createSuccessResult(result));
    }
  });
});

router.post("/register", (request, response) => {
  const { name, email, address } = request.body;

  const query = `insert into Customer_TB (name, email, address) values (?, ?, ?);`;

  db.pool.execute(query, [name, email, address], (error, result) => {
    if (error) {
      response.send(utils.createErrorResult(error));
    } else {
      response.send(
        utils.createSuccessResult(result, "Customer created successfully")
      );
    }
  });
});


router.post("/search", (request, response) => {
  const { email } = request.body;

  const query = `select name, address from Customer_TB where email = ?`;

  db.pool.execute(query, [ email ], (error, result) => {
    if (error) {
      response.send(utils.createErrorResult(error));
    } else {
      response.send(
        utils.createSuccessResult(result, "Customer found")
      );
    }
  });
});


module.exports = router;
