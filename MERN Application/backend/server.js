const express = require("express");
const utils = require("./utils");
const cors = require("cors");

const app = express();

app.use(cors());

app.use(express.json());

app.use((request, response, next) => {
  if (
    request.url == "/user/register" || request.url == "/user/search" || request.url 
    == "/user/"
  ) {
    next();
  } else {
      response.send(utils.createErrorResult());
      return;
    }
})


const userRouter = require("./routes/user");
app.use("/user", userRouter);

app.listen(4002, "0.0.0.0", () => {
  console.log("server started on port 4002");
});
